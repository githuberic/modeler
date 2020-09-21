package com.lgq.modeler.bk.concurrent.CallableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by eric on 2018/12/4.
 */
public class CallableFutureExec {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();

        Future<Integer> result = executorService.submit(task);
        executorService.shutdown();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(">>>Main thread doing...");

        try {
            result.get();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }

        System.out.println(">>>All thread done!");
    }
}

