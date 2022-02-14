package com.lgq.jbasic.concurrent.pb7con.WordCountConcurrentHashMap;

import java.util.concurrent.BlockingQueue;

/**
 * @author lgq
 */
public class Parser implements Runnable {
    private BlockingQueue<Page> queue;

    public Parser(BlockingQueue<Page> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Iterable<Page> pages = new Pages(100000, "enwiki.xml");
            for (Page page : pages) {
                queue.put(page);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
