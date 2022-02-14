package com.lgq.jbasic.concurrent.e1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author lgq
 */
public class CallableExec {
    public static void main(String[] args) {
        Callable<NamTemp> callable = () -> {
            Thread.sleep(50);
            return new NamTemp("lgq");
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Future 这种方法可以是同步等待线处理结果
        Future<NamTemp> namTempFuture = executorService.submit(callable);

        try {
            NamTemp namTemp = namTempFuture.get();
            System.out.println(">>>Future result=" + namTemp.name);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println(">>>Main thread done...");
    }
}

class NamTemp {
    String name;

    NamTemp(String name) {
        this.name = name;
    }
}
