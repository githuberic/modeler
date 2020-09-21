package com.lgq.modeler.bk.concurrent.CallableFutureTask;

import java.util.concurrent.Callable;

/**
 * Created by eric on 2018/12/4.
 */
class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(">>>Sub thread doing...");
        Thread.sleep(2000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}
