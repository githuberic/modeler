package com.lgq.modeler.multiplethread.threadloacal;

/**
 * Created by eric on 2019/12/25.
 *
 * @author lgq
 */
public class ThreadLocalV1 {
    public ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public void setThreadLocal(Integer number) {
        threadLocal.set(number);
    }

    public void getThreadLocal() {
        System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
    }

    public static void main(String[] args) {
        ThreadLocalV1 threadLocalV1 = new ThreadLocalV1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocalV1.setThreadLocal(10);
                threadLocalV1.getThreadLocal();
            }
        }, "th1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocalV1.setThreadLocal(5);
                threadLocalV1.getThreadLocal();
            }
        }, "th2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocalV1.setThreadLocal(15);
                threadLocalV1.getThreadLocal();
            }
        }, "th3").start();
    }
}
