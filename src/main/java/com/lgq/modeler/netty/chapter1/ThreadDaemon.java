package com.lgq.modeler.netty.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * @author lgq
 */
public class ThreadDaemon {
    public static void main(String[] args) throws Exception{
        long start = System.nanoTime();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.DAYS.sleep(Long.MAX_VALUE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Daemon-T");
        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(15);
        System.out.print("System exit, program execute," + (System.nanoTime() - start) / 1000 / 100 / 1000 + "s");
    }
}
