package com.epam.bench.concurrency;

import java.util.concurrent.*;

public class TimeOutTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            } finally {
                executor.shutdown();
            }
        });

        future.get(1, TimeUnit.SECONDS);
    }
}
