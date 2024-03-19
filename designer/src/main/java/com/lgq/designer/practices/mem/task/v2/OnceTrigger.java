package com.lgq.designer.practices.mem.task.v2;

/**
 * @author lgq
 */
public class OnceTrigger implements Trigger {

    private final long executionTime;

    public OnceTrigger(long delay) {
        this.executionTime = System.currentTimeMillis() + delay;
    }

    @Override
    public long getExecutionTime(long lastExecutionTime) {
        return executionTime;
    }
}
