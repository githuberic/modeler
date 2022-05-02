package com.lgq.jbasic.concurrent.counter.e2;

public class CounterE2 {
    //公共变量
    int count = 0;

    public static void main(String[] args) {
        CounterE2 c2 = new CounterE2();

        MyRunnable r2 = c2.new MyRunnable();
        for (int i = 0; i < 3; i++) {
            new Thread(r2).start();
        }
    }

    class MyRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                // 锁住的是同一对象
                synchronized (this) {
                    if (count >= 1000) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + ":count:" + (++count));
                }
            }
        }
    }
}
