package com.lgq.designer.practices.mem.task.v2;

/**
 * @author lgq
 */
public class VoidTask implements Task<Void> {
    @Override
    public Void execute() {
        System.out.println(">>>Executing VoidTask at: " + System.currentTimeMillis());
        return null;
    }
}
