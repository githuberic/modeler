package com.lgq.modeler.bk.concurrent.CallableBasic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by eric on 2018/12/4.
 */
public class CallableExec {
    public static void main(String[] args) {
        Callable<NamTemp> callable = new Callable<NamTemp>() {
            @Override
            public NamTemp call() throws Exception {
                Thread.sleep(50);
                return new NamTemp("Eric");
            }
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

    static class NamTemp {
        private NamTemp(String name) {
            this.name = name;
        }

        private String name;
    }
}
