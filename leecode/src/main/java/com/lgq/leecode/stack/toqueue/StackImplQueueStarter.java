package com.lgq.leecode.stack.toqueue;

import java.util.Stack;

/**
 * @author lgq
 */
public class StackImplQueueStarter {
    public static void main(String[] args) {
        StackImplQueue stack = new StackImplQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
    }
}
