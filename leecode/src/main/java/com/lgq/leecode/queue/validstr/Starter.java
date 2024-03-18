package com.lgq.leecode.queue.validstr;

import java.util.Stack;

/**
 * @author lgq
 */
public class Starter {

    public static void main(String[] args) {
        String str = "()[]{}{{";
        System.out.println(isValid(str));
    }

    private static boolean isValid(String str) {
        if (str.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.pop() != getLeft(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static char getLeft(char c) {
        if (c == ')') {
            return '(';
        } else if (c == ']') {
            return '[';
        } else {
            return '{';
        }
    }
}
