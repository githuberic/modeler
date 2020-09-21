package com.lgq.modeler.multiplethread.chapter1;

/**
 * Created by eric on 2019/12/14.
 *
 * @author lgq
 */
public class MultipleCPUV1 {
    private long count = 0;

    private void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count++;
        }
    }

    private long calc() throws Throwable {
        Thread thread1 = new Thread(() -> {
            add10K();
        });
        Thread thread2 = new Thread(() -> {
            add10K();
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        return count;
    }

    public static void main(String[] args) throws Throwable {
        MultipleCPUV1 multipleCPUV1 = new MultipleCPUV1();
        System.out.println(multipleCPUV1.calc());
    }
}
