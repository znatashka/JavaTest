package com.epam.bench.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAnyTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                callable("task1", 2),
                callable("task2", 1),
                callable("task3", 3)
        );

        String result = executor.invokeAny(callables);
        System.out.println(result);
    }

    private static Callable<String> callable(String result, int sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }
}
