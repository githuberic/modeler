package com.lgq.jbasic.concurrent.e1;

import java.util.concurrent.*;

/**
 * @author lgq
 */
public class CallableFutureTask {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(new TaskFT());
        executorService.submit(futureTask);
        executorService.shutdown();

        try {
            Thread.sleep(1000);
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

class TaskFT implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(">>>Sub thread doing...");
        Thread.sleep(1000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}
