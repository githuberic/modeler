package com.lgq.jbasic.concurrent.pb7con.CountingBetter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lgq
 */
public class Counting {
    public static void main(String[] args) throws InterruptedException {
        final AtomicInteger counter = new AtomicInteger();
        class CountingThread extends Thread {
            @Override
            public void run() {
                for (int x = 0; x < 10000; ++x) {
                    counter.incrementAndGet();
                }
            }
        }

        CountingThread t1 = new CountingThread();
        CountingThread t2 = new CountingThread();

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(counter.get());
    }
}
