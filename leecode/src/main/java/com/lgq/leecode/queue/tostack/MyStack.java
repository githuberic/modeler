package com.lgq.leecode.queue.tostack;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queueIn;
    private Queue<Integer> queueOut;

    public MyStack() {
        queueIn = new ArrayDeque<>();
        queueOut = new ArrayDeque<>();
    }

    /**
     * 在加入元素时先将q1中的元素依次出栈压入q2，然后将新加入的元素压入q1，再将q2中的元素依次出栈压入q1
     *
     * @param val
     */
    public void push(int val) {
        while (queueIn.size() > 0) {
            queueOut.add(queueIn.poll());
        }
        queueIn.add(val);

        while (queueOut.size() > 0) {
            queueIn.add(queueOut.poll());
        }
    }

    public void pop() {
        queueIn.poll();
    }

    public int top() {
        return queueIn.peek();
    }

    public boolean isEmpty() {
        return queueIn.isEmpty();
    }
}
