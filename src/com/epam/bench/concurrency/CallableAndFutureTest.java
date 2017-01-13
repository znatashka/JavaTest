package com.epam.bench.concurrency;

import java.util.concurrent.*;

public class CallableAndFutureTest {

    public static void main(String[] args) {

        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

        System.out.println("future done? " + future.isDone());

        try {
            Integer result = future.get();

            System.out.println("future done? " + future.isDone());
            System.out.println("result: " + result);

            executor.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
