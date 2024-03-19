package com.lgq.designer.practices.mem.task;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lgq
 */
public class TimeScheduler {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(">>>执行定时任务" + new Date());
            }
        };

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        // 初始延迟时间（秒）
        int initialDelay = 0;
        // 任务执行间隔（秒）
        int period = 5;
        // 时间单位
        TimeUnit timeUnit = TimeUnit.SECONDS;
        scheduledExecutorService.scheduleAtFixedRate(myTask, initialDelay, period, timeUnit);
        scheduledExecutorService.scheduleAtFixedRate(runnable, initialDelay, period, timeUnit);
    }
}
