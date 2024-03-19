package com.lgq.designer.practices.mem.task;

/**
 * @author lgq
 */
public class InMemSchedulerStarter {
    public static void main(String[] args) {
        execute();
    }

    private static void execute() {
        InMemScheduler scheduler = new InMemScheduler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(">>>定时任务执行中:" + System.currentTimeMillis());
            }
        };

        scheduler.scheduleAtFixedTime(runnable, 1000, 2000);

        // 模拟程序运行一段时间
        try {
            // 让主线程休眠10秒，以便观察定时任务的执行
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.shutdown();
    }
}
