package com.lgq.jbasic.concurrent.lockv1;

/**
 * Created by eric on 2019/12/1.
 * 1：可重入锁 get()方法中顺利进入了set()方法，说明synchronized的确是可重入锁。
 * 2：非公平锁：分析打印Log，thread-0先进入get方法体，这个时候thread-1、thread-2、thread-3等待进入，但当thread-0离开时，thread-2却先进入了方法体，没有按照thread-1、thread-2、thread-3的顺序进入get方法体，说明sychronized的确是非公平锁。
 * 3：独占锁而且在一个线程进入get方法体后，其他线程只能等待，无法同时进入，验证了synchronized是独占锁。
 *
 * @author lgq
 */
public class MyLock implements Runnable{

    /**
     * get()方法中顺利进入了set()方法，说明synchronized的确是可重入锁。
     */
    public synchronized void get() {
        System.out.println("2 enter thread name-->" + Thread.currentThread().getName());
        //reentrantLock.lock();
        System.out.println("3 get thread name-->" + Thread.currentThread().getName());
        set();
        //reentrantLock.unlock();
        System.out.println("5 leave run thread name-->" + Thread.currentThread().getName());
    }

    public synchronized void set() {
        //reentrantLock.lock();
        System.out.println("4 set thread name-->" + Thread.currentThread().getName());
        //reentrantLock.unlock();
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
