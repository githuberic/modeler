package com.lgq.jbasic.mem;

/**
 * Created by eric on 2019/12/13.
 * 虚拟机栈和本地方法栈OOM测试
 *
 * -Xss128k
 *
 * @author lgq
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    private void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF stackSOF = new JavaVMStackSOF();

        try {
            stackSOF.stackLeak();
        } catch (Throwable ex) {
            System.out.println(">>>stack length:" + stackSOF.stackLength);
            throw ex;
        }
    }
}
