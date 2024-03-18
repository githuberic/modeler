package com.lgq.leecode.queue.removeduplicates;

import java.util.Stack;

/**
 * @author lgq
 */
public class starter {
    public static void main(String[] args) {
        String str = "abbaca";
        System.out.println(removeDuplicates(str));
    }

    private static String removeDuplicates(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        String strRet = "";
        while (!stack.isEmpty()) {
            strRet = stack.pop() + strRet;
        }
        return strRet;
    }
}
