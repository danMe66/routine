package club.nazarick.threadpool;

import club.nazarick.threadpool.domain.Input;
import club.nazarick.threadpool.domain.Output;
import club.nazarick.threadpool.service.Input2OutputService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootTest
@Slf4j
class ThreadPoolApplicationTests {

    private final Input2OutputService input2OutputService;

    @Autowired
    ThreadPoolApplicationTests(Input2OutputService input2OutputService) {
        this.input2OutputService = input2OutputService;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void multiProcess() {
        log.info("Multi process start");
        List<Input> inputList = Arrays.asList(new Input(1), new Input(2), new Input(3));
        System.out.println(input2OutputService.multiProcess(inputList));
        log.info("Multi process end");
    }

    @Test
    void asyncProcess() throws InterruptedException, ExecutionException {
        log.info("Async process start");
        Future<Output> future = input2OutputService.asyncProcess(new Input(1));
        while (true) {
            if (future.isDone()) {
                System.out.println(future.get());
                log.info("Async process end");
                break;
            }
            log.info("Continue doing something else.");
            Thread.sleep(100);
        }
    }
}
