package com.lgq.designer.practices.mem.task.v2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author lgq
 */
public class TaskManagerService {
    private final Scheduler scheduler;
    private final ConcurrentHashMap<ScheduledFuture<?>, Trigger> futureTriggers;

    public TaskManagerService(Scheduler scheduler) {
        this.scheduler = scheduler;
        this.futureTriggers = new ConcurrentHashMap<>();
    }

    public <T> void scheduleRepeatingTask(Task<T> task, Trigger trigger) {
        ScheduledFuture<T> future = scheduler.scheduleTask(task, 0, TimeUnit.MILLISECONDS);
        futureTriggers.put(future, trigger);

        /*
        future.whenComplete((result, throwable) -> {
            if (throwable == null) {
                long nextExecutionTime = trigger.getExecutionTime(System.currentTimeMillis());
                scheduleRepeatingTask(task, trigger); // 递归调用以重新安排任务
            } else {
                futureTriggers.remove(future); // 如果有异常，则停止调度
                throwable.printStackTrace();
            }
        });*/
    }

    public void shutdown() {
        scheduler.shutdown();
        futureTriggers.clear();
    }
}
