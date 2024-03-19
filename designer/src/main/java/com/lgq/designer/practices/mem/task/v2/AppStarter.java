package com.lgq.designer.practices.mem.task.v2;

/**
 * @author lgq
 */
public class AppStarter {
    public static void main(String[] args) {
        Scheduler scheduler = new SimpleScheduler();
        TaskManagerService taskManagerService = new TaskManagerService(scheduler);

        // 调度无返回值的任务
        VoidTask voidTask = new VoidTask();
        taskManagerService.scheduleRepeatingTask(voidTask, new FixedIntervalTrigger(2000));

        // 模拟程序运行一段时间
        try {
            Thread.sleep(10000); // 让主线程休眠10秒，以便观察定时任务的执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 关闭调度器
        taskManagerService.shutdown();
    }
}
