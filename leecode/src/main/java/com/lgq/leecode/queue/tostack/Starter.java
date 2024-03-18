package com.lgq.leecode.queue.tostack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author lgq
 */
public class Starter {
    public static void main(String[] args) {
        MyStack queueD = new MyStack();
        queueD.push(1);
        queueD.push(2);
        queueD.push(7);
        queueD.push(8);

        System.out.println(queueD.top());
    }
}
