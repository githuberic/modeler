package com.lgq.jbasic.reference.strong;

import java.util.concurrent.TimeUnit;

/**
 * @author lgq
 * 强引用
 */
public class StrongReferenceExec {
    public static void main(String[] args) throws Exception {
        StrongReferenceExec execObj = new StrongReferenceExec();

        System.gc();
        TimeUnit.SECONDS.sleep(1);
        // 结果输出false，表明没有被垃圾回收。
        System.out.println(execObj == null);
    }
}
