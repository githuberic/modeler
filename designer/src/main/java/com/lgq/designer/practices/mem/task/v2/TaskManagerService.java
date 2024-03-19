package com.lgq.designer.practices.mem.task.v2;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author lgq
 */
public class TaskManagerService {
    private final SimpleScheduler scheduler;
    private final ConcurrentHashMap<ScheduledFuture<?>, Trigger> futureTriggers;

    public TaskManagerService() {
        int corePoolSize = Runtime.getRuntime().availableProcessors() + 1;
        this.scheduler = new SimpleScheduler(corePoolSize);

        this.futureTriggers = new ConcurrentHashMap<>();
    }

    public <T> ScheduledFuture<T> scheduleRepeatingTask(Task<T> task, Trigger trigger) throws ExecutionException, InterruptedException {
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
        return future;
    }

    public void shutdown() {
        scheduler.shutdown();
        futureTriggers.clear();
    }
}
