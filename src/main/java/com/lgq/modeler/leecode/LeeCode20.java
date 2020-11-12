package com.lgq.modeler.leecode;

import java.util.Stack;

/**
 * 给定一个只包括 ‘(’，’)’，’{’，’}’，’[’，’]’ 的字符串，判断字符串是否有效。
 *
 * @author lgq
 */
public class LeeCode20 {
    private static boolean isValid(String str) {
        if (str.contains("()") || str.contains("{}") || str.contains("[]")) {
            return isValid(str.replace("()", "")
                    .replace("[]", "")
                    .replace("{}", ""));
        } else {
            return "".equals(str);
        }
    }

    public static boolean isValid2(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{}{{[[()]]}}"));
        System.out.println(isValid2("{}{{[[()]]}}"));
    }
}
