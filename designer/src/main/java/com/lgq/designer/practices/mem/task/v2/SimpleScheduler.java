package com.lgq.designer.practices.mem.task.v2;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/***
 * @author lgq
 */
public class SimpleScheduler implements Scheduler {
    private ScheduledExecutorService executorService;

    public SimpleScheduler() {
        executorService = new ScheduledThreadPoolExecutor(10);
    }

    @Override
    public <T> ScheduledFuture<T> scheduleTask(Task<T> task, long delay, TimeUnit unit) {
        return executorService.schedule(task::execute, delay, unit);
    }

    @Override
    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
