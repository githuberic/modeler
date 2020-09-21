package com.lgq.modeler.multiplethread.lockv2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by eric on 2019/12/1.
 * 1：ReentrantLock既可以构造公平锁又可以构造非公平锁，默认为非公平锁，
 * 2：可重入锁，当然默认的确是非公平锁。thread-0持有锁期间，thread-1等待拥有锁，
 * 当thread-0释放锁时thread-3先获取到锁，并非按照先后顺序获取锁的。
 *
 * @author lgq
 */
public class MyLock implements Runnable {
    private ReentrantLock reentrantLock = new ReentrantLock();

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
