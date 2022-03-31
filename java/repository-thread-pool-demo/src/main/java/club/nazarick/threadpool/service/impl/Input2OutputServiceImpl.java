package club.nazarick.threadpool.service.impl;

import club.nazarick.threadpool.domain.Input;
import club.nazarick.threadpool.domain.Output;
import club.nazarick.threadpool.service.Input2OutputService;
import club.nazarick.threadpool.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

/**
 * 业务实现类
 *
 * @author liudandan
 * @date 2022/3/28
 */
@Service
@Slf4j
public class Input2OutputServiceImpl implements Input2OutputService {
    /**
     * 单个处理
     *
     * @param input 输入对象
     * @return 输出对象
     */
    @Override
    public Output singleProcess(Input input) {
        log.info("单步处理开始：线程：{} 执行任务：{}", Thread.currentThread().getName(), input);
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return new Output(false, null);
        }
        log.info("单步处理结束：线程：{} 执行任务：{}", Thread.currentThread().getName(), input);
        return new Output(true, String.valueOf(2 * input.getI() + 1));
    }

    /**
     * 批量处理
     *
     * @param inputList 输入对象列表
     * @return 输出对象列表
     */
    @Override
    public List<Output> multiProcess(List<Input> inputList) {
        log.info("批量处理开始：线程：{} ", Thread.currentThread().getName());
        ThreadPoolTaskExecutor executor
                = SpringUtils.getBean("threadPoolTaskExecutor", ThreadPoolTaskExecutor.class);
        CountDownLatch latch = new CountDownLatch(inputList.size());
        List<Output> outputList = Collections.synchronizedList(new ArrayList<>(inputList.size()));

        for (Input input : inputList) {
            log.info("批量单条处理开始：线程：{} 执行任务：{}", Thread.currentThread().getName(), input);
            executor.execute(() -> {
                try {
                    Output output = singleProcess(input);
                    outputList.add(output);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return outputList;
    }

    /**
     * 异步处理
     *
     * @param input 输入对象
     * @return 输出Future对象
     */
    @Async("threadPoolTaskExecutor")
    @Override
    public Future<Output> asyncProcess(Input input) {
        log.info("异步单步处理开始：线程：{} 执行任务：{}", Thread.currentThread().getName(), input);
        Future<Output> outputFuture = new AsyncResult<>(singleProcess(input));
        log.info("异步单步处理结束：线程：{} 执行任务：{}", Thread.currentThread().getName(), input);
        return outputFuture;
    }
}
