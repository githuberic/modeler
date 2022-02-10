package com.lgq.jbasic.concurrent.pb7con.WordCountProducerConsumer;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author lgq
 */
public class WordCount {
    public static void main(String[] args) throws Exception {
        ArrayBlockingQueue<Page> queue = new ArrayBlockingQueue<>(100);
        HashMap<String, Integer> counts = new HashMap<>();

        Thread counter = new Thread(new Counter(queue, counts));
        Thread parser = new Thread(new Parser(queue));

        long start = System.currentTimeMillis();

        counter.start();
        parser.start();
        parser.join();
        queue.put(new PoisonPill());
        counter.join();
        long end = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (end - start) + "ms");

        // for (Map.Entry<String, Integer> e: counts.entrySet()) {
        //   System.out.println(e);
        // }
    }
}
