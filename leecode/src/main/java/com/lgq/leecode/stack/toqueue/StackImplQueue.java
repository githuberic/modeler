package com.lgq.leecode.stack.toqueue;

import java.util.Stack;

/**
 * @author lgq；
 */
public class StackImplQueue {

    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public StackImplQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        dupmStackIn();
        return stackOut.pop();
    }

    public int peek() {
        dupmStackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    private void dupmStackIn() {
        if (!stackOut.isEmpty()) {
            return;
        }

        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
}
