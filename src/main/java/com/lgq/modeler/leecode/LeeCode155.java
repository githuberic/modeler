package com.lgq.modeler.leecode;

import java.util.Stack;

/**
 * 155. 最小栈
 *
 * @author lgq
 */
public class LeeCode155 {
    static class MinStack {
        private Stack<Integer> data;
        private Stack<Integer> minData;

        public MinStack() {
            data = new Stack<>();
            minData = new Stack<>();
        }

        public void push(int x) {
            data.push(x);
            if (minData.isEmpty() || minData.peek() >= x) {
                minData.add(x);
            }
        }

        public void pop() {
            if (!data.isEmpty()) {
                int top = data.pop();
                // 注意：声明成 int 类型，这里完成了自动拆箱，从 Integer 转成了 int，
                // 因此下面的比较可以使用 "==" 运算符
                if (top == minData.peek()) {
                    minData.pop();
                }
            }
        }

        public int top() {
            if (!data.isEmpty()) {
                return data.peek();
            }
            return 0;
        }

        public int getMin() {
            if (!minData.isEmpty()) {
                return minData.peek();
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
    }
}
