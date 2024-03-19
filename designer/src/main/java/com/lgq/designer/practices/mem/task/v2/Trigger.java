package com.lgq.designer.practices.mem.task.v2;

/**
 * @author lgq
 */
public interface Trigger {
    long getExecutionTime(long lastExecutionTime);
}
