package com.lgq.modeler.bk.concurrent.CallableFutureTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by eric on 2018/12/4.
 */
public class ExecMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);

        executorService.submit(futureTask);
        executorService.shutdown();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(">>>Main thread doing...");

        try {
            System.out.println(">>>Task result=" + futureTask.get());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }

        System.out.println(">>>All thread done!");
    }
}
