package com.lgq.designer.practices.mem.task.v1;

import java.util.TimerTask;

/**
 * @author lgq
 */
public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println(">>>定时任务执行中...");
    }
}
