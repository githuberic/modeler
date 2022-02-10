package com.lgq.jbasic.concurrent.e1;

import java.util.concurrent.*;

/**
 * @author lgq
 */
public class CallableFuture {
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
            Integer value = result.get();
            System.out.println("Value=" + value);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }

        System.out.println(">>>All thread done!");
    }
}


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
