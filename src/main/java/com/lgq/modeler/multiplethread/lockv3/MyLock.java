package com.lgq.modeler.multiplethread.lockv3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by eric on 2019/12/1.
 * 公平锁在多个线程想要同时获取锁的时候，会发现再排队，按照先来后到的顺序进行。
 *
 *
 *
 * @author lgq
 */
public class MyLock implements Runnable {
    private ReentrantLock reentrantLock = new ReentrantLock(true);

    public void get() {
        System.out.println("2 enter thread name-->" + Thread.currentThread().getName());
        reentrantLock.lock();
        System.out.println("3 get thread name-->" + Thread.currentThread().getName());
        set();
        reentrantLock.unlock();
        System.out.println("5 leave run thread name-->" + Thread.currentThread().getName());
    }

    public void set() {
        reentrantLock.lock();
        System.out.println("4 set thread name-->" + Thread.currentThread().getName());
        reentrantLock.unlock();
    }

    @Override
    public void run() {
        System.out.println("1 run thread name-->" + Thread.currentThread().getName());
        get();
    }

    public static void main(String[] args) {
        MyLock test = new MyLock();
        for (int i = 0; i < 10; i++) {
            new Thread(test, "thread-" + i).start();
        }
    }
}
