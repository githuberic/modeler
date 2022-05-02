package com.lgq.jbasic.concurrent.counter.e3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lqg
 */
public class CounterE3 {
    static AtomicInteger ai = new AtomicInteger(0);
    static CountDownLatch cdl = new CountDownLatch(1000);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1000; i++) {
            exec.execute(() -> {
                System.out.println(Thread.currentThread().getName() + ":" + ai.getAndIncrement());
                cdl.countDown();
            });
        }
        cdl.await();
        System.out.println(ai.get());
        exec.shutdown();
    }
}
