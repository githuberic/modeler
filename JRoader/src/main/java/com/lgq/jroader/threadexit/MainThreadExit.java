package com.lgq.jroader.threadexit;


import java.io.IOException;

/**
 * @author lgq
 */
public class MainThreadExit {

    public static void main(String[] args) throws IOException {
        System.out.println("main start");
        Thread thread = new Thread(() -> {
            System.out.println("t1 start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 exit");
        });
        thread.setDaemon(true);
        thread.start();
        System.out.println("main exit");
    }
}
