package com.epam.bench;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    private static AtomicInteger counter = new AtomicInteger(0);

    private static class MyThread extends Thread {
        @Override
        public void run() {
//            synchronized (MyThread.class) {
            for (int i = 0; i < 10_000; i++) {
                counter.incrementAndGet();
            }
//            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter);
    }

    enum E implements I {

        W(1) {
            @Override
            public void g() {

            }

            @Override
            void d() {

            }
        }, E(2) {
            @Override
            public void g() {

            }


            @Override
            void d() {

            }
        }, R(3) {
            @Override
            public void g() {

            }

            @Override
            void d() {

            }
        };

        E(int a) {

        }

        abstract void d();
    }

    interface I {
        void g();
    }
}
