package club.nazarick.threadpool.service;

import club.nazarick.threadpool.domain.Input;
import club.nazarick.threadpool.domain.Output;

import java.util.List;
import java.util.concurrent.Future;

/**
 *
 *
 * @author liudandan
 * @date 2022/3/28
 */
public interface Input2OutputService {
    /**
     * 单个处理
     *
     * @param input
     * @return
     */
    Output singleProcess(Input input);

    /**
     * 批量处理
     *
     * @param inputList
     * @return
     */
    List<Output> multiProcess(List<Input> inputList);

    /**
     * 异步处理
     *
     * @param input
     * @return
     */
    Future<Output> asyncProcess(Input input);
}
