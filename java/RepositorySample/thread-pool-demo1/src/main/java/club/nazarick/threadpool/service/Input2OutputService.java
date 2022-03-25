package club.nazarick.threadpool.service;

import club.nazarick.threadpool.domain.Input;
import club.nazarick.threadpool.domain.Output;

import java.util.List;
import java.util.concurrent.Future;

public interface Input2OutputService {
    Output singleProcess(Input input);
    List<Output> multiProcess(List<Input> inputList);
    Future<Output> asyncProcess(Input input);
}
