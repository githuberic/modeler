package com.lgq.multiplethread.threadloacal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eric on 2019/12/25.
 *
 * @author lgq
 */
public class ThreadLocalV2 {
    public ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    static class ThreadLocalRunner extends Thread {
        //static List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        static ThreadLocal<List<Integer>> threadLocal = new ThreadLocal<List<Integer>>() {
            @Override
            protected List<Integer> initialValue() {
                return new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
            }
        };

        @Override
        public void run() {
            List<Integer> threadList = threadLocal.get();
            threadList.add(threadList.size());
            System.out.println(threadList.toString());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ThreadLocalRunner().start();
        new ThreadLocalRunner().start();
        new ThreadLocalRunner().start();
        new ThreadLocalRunner().start();
    }
}
