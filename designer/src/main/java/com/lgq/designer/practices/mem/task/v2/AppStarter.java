package com.lgq.designer.practices.mem.task.v2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author lgq
 */
public class AppStarter {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        execute();
    }

    private static void execute() throws InterruptedException, ExecutionException {

        TaskManagerService taskManagerService = new TaskManagerService();

        // 调度无返回值的任务
        VoidTask voidTask = new VoidTask();
        taskManagerService.scheduleRepeatingTask(voidTask, new FixedIntervalTrigger(2000));

        // 调度有返回值的任务
        ExampleTask taskWithReturn = new ExampleTask("With return value");
        ScheduledFuture<String> future
                = taskManagerService.scheduleRepeatingTask(taskWithReturn, new OnceTrigger(5000));
        // 等待任务完成并获取结果
        System.out.println("Task result: " + future.get());

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
