package com.lgq.jbasic.callback;

/**
 * @author lqq
 */
public class CallbackTest1 {
    public static void main(String[] args) {
        Student student = new Student("老刘-lgq");
        student.setCallback(new Teacher());
        student.doTask();
    }
}

class Student {
    private String name;
    private ICallback callback;

    public Student(String name) {
        this.name = name;
    }

    public void setCallback(ICallback callback) {
        this.callback = callback;
    }

    public void doTask() {
        for (int i = 1; i <= 2; i++) {
            callback.getResult(i + this.name);
        }
    }
}

class Teacher implements ICallback {
    @Override
    public void getResult(String name) {
        System.out.println("Task：" + name + ",done");
    }
}


interface ICallback {
    /**
     * @param name
     */
    void getResult(String name);
}