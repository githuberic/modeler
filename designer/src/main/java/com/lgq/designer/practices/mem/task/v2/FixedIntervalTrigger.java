package com.lgq.designer.practices.mem.task.v2;

/**
 * @author
 */
public class FixedIntervalTrigger implements Trigger {

    private final long interval;

    public FixedIntervalTrigger(long interval) {
        this.interval = interval;
    }

    @Override
    public long getExecutionTime(long lastExecutionTime) {
        return lastExecutionTime + interval;
    }
}
