package com.lgq.designer.practices.mem.task.v2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author lgq
 */
public interface Scheduler {
    <T> ScheduledFuture<T> scheduleTask(Task<T> task, long delay, TimeUnit unit);
    void shutdown();
}
