package com.lgq.multiplethread.pb7con.WordCountConcurrentHashMap;

import java.util.concurrent.*;

/**
 * @author lgq
 */
public class WordCount {
    private static final int NUM_COUNTERS = 4;

    public static void main(String[] args) throws Exception {
        ArrayBlockingQueue<Page> queue = new ArrayBlockingQueue<>(100);
        ConcurrentHashMap<String, Integer> counts = new ConcurrentHashMap<>();
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < NUM_COUNTERS; ++i) {
            executor.execute(new Counter(queue, counts));
        }

        Thread parser = new Thread(new Parser(queue));
        long start = System.currentTimeMillis();
        parser.start();
        parser.join();
        for (int i = 0; i < NUM_COUNTERS; ++i){
            queue.put(new PoisonPill());}
        executor.shutdown();
        executor.awaitTermination(10L, TimeUnit.MINUTES);
        long end = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (end - start) + "ms");

        // for (Map.Entry<String, Integer> e: counts.entrySet()) {
        //   System.out.println(e);
        // }
    }
}
