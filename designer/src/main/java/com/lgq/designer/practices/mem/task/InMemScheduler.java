package com.lgq.designer.practices.mem.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author lgq
 */
public class InMemScheduler {
    private final ScheduledExecutorService scheduler;

    public InMemScheduler() {
        // 创建一个单线程的ScheduledExecutorService
        scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    /**
     * 提交一个定时任务到调度器
     *
     * @param task         要执行的任务
     * @param initialDelay 首次执行前的延迟时间，单位：毫秒
     * @param period       两次执行之间的周期时间，单位：毫秒
     * @return 一个表示挂起任务的ScheduledFuture
     */
    public ScheduledFuture<?> scheduleAtFixedTime(Runnable task, long initialDelay, long period) {
        return scheduler.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    public void shutdown() {
        System.out.println(">>>任务开始shutdown()...");
        scheduler.shutdown();

        try {
            // 等待所有任务执行完毕或者等待一段时间后退出
            if (!scheduler.awaitTermination(60, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException ex) {
            // (在中断的情况下) 强制停止所有任务
            scheduler.shutdownNow();
            // 保持中断状态
            Thread.currentThread().interrupt();
        }
    }
}
