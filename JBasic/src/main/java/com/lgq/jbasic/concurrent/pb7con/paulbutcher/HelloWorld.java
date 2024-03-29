package com.lgq.jbasic.concurrent.pb7con.paulbutcher;

/**
 * @author lgq
 */
public class HelloWorld {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(() -> System.out.println("Hello from new thread"));

        myThread.start();
        Thread.yield();
        System.out.println("Hello from main thread");
        myThread.join();
    }
}
