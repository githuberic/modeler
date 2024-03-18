package com.lgq.leecode.stack.evalrpn;

import java.util.Stack;

/**
 * @author lgq
 * <p>
 * 思路分析：逆波兰表达式求值
 * <p>
 * 1、建一个栈。
 * <p>
 * 2、利用增强for循环遍历，如果当前字符为数字，则压入栈中；如果当前字符为“+、-、* 、/”运算符，则弹出两个元素进行运算，并将运算结果压入栈中。
 * <p>
 * 3、注意String 和 Integer 之间的 类型转换
 */
public class Starter {

    public static void main(String[] args) {
        String[] arrStr = new String[]{"10", "6", "9", "3", "+", "-11", " * ", "/", " * ", "17", "+", "5", "+"};
        System.out.println(evalRPN(arrStr));
    }

    private static int evalRPN(String[] arrStr) {
        Stack<Integer> stack = new Stack<>();

        for (String str : arrStr) {
            str = str.trim();
            if ("+".equals(str)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("_".equals(str)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(str)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(str)) {
                int num1 = stack.pop();
                stack.push(stack.pop() / num1);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.pop();
    }
}
