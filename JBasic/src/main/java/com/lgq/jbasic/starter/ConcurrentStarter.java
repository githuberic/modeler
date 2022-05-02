package com.lgq.jbasic.starter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lgq
 */
public class ConcurrentStarter {
    private static final int TIMES = 100 * 1000 * 1000;

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            service.submit(() -> {
            });
        }
        service.shutdown();
        long t2 = System.currentTimeMillis();
        System.out.printf("elapsed time: %.3fs\n", (t2 - t1) / 1000f);
    }
}
