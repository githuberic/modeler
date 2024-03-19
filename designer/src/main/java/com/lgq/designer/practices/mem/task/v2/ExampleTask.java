package com.lgq.designer.practices.mem.task.v2;

/**
 * @author lgq
 */
public class ExampleTask implements Task<String> {

    private final String str;

    public ExampleTask(String str) {
        this.str = str;
    }

    @Override
    public String execute() {
        System.out.println(">>>Executing task: " + str);
        return "Result for " + str;
    }
}
