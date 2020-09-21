package com.lgq.modeler.multiplethread.chapter2;

/**
 * Created by eric on 2019/12/15.
 *
 * @author lgq
 */
public class SafeCalcV1 {
    private long value = 0L;

    private synchronized long get() {
        return this.value;
    }

    private synchronized void addOne() {
        this.value++;
    }

    public static void main(String[] args) throws Throwable {
        final SafeCalcV1 safeCalcV1 = new SafeCalcV1();
        for (int i = 0; i < 100; i++) {
            Thread thread1 = new Thread(() -> {
                safeCalcV1.addOne();
            });
            Thread thread2 = new Thread(() -> {
                safeCalcV1.addOne();
            });
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            System.out.println(safeCalcV1.get());
        }
    }
}
