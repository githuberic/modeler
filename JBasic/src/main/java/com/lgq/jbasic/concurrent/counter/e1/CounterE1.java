package com.lgq.jbasic.concurrent.counter.e1;

/**
 * @author lgq
 */
public class CounterE1 {

    int count = 0;

    public static void main(String[] args) {
        CounterE1 counterE1 = new CounterE1();
        new Thread(counterE1.new MyRunnable()).start();
        new Thread(counterE1.new MyRunnable()).start();
        new Thread(counterE1.new MyRunnable()).start();
    }

    class MyRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                // 锁住的是整个MyRunnable类
                synchronized (MyRunnable.class) {
                    if (count >= 1000) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + ":count:" + (++count));
                }
            }
        }
    }
}
