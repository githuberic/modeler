package com.lgq.multiplethread.lockv4;

/**
 * Created by eric on 2019/12/1.
 *
 * @author lgq
 */
public class MyLock {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> Cache.put("key", new String(Thread.currentThread().getName() + " joke")), "threadW-" + i).start();

            new Thread(() -> System.out.println(Cache.get("key")), "threadR-" + i).start();

            new Thread(() -> Cache.clear(), "threadC-" + i).start();
        }
    }
}
