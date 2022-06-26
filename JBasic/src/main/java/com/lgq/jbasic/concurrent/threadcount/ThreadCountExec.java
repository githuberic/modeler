package com.lgq.jbasic.concurrent.threadcount;

import java.util.Set;

/**
 * @author lgq
 */
public class ThreadCountExec {
    public static void main(String[] args) {
        System.out.println(">>>Hello world");
        int activeCount = Thread.activeCount();
        System.out.println(">>>Active thread count：" + activeCount);
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        for (Thread t : threadSet) {
            System.out.println(">>>Thread " + t.getId() + ":" + t.getName());
        }
    }
}
