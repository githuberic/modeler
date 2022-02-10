package com.lgq.jbasic.concurrent.pb7con.WordCountSynchronizedHashMap;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WordCount {

    private static final int NUM_COUNTERS = 2;

    public static void main(String[] args) throws Exception {
        ArrayBlockingQueue<Page> queue = new ArrayBlockingQueue<Page>(100);
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < NUM_COUNTERS; ++i) {
            executor.execute(new Counter(queue, counts));
        }

        Thread parser = new Thread(new Parser(queue));
        long start = System.currentTimeMillis();
        parser.start();
        parser.join();
        for (int i = 0; i < NUM_COUNTERS; ++i) {
            queue.put(new PoisonPill());
        }
        executor.shutdown();
        executor.awaitTermination(10L, TimeUnit.MINUTES);
        long end = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (end - start) + "ms");

        // for (Map.Entry<String, Integer> e: counts.entrySet()) {
        //   System.out.println(e);
        // }
    }
}
