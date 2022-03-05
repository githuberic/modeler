package com.lgq.ds.stack;

import org.junit.Test;

/**
 * @author lgq
 */
public class GeneralArrayStackTest {

    @Test
    public void testGAS() {
        String tmp;
        GeneralArrayStack<String> astack = new GeneralArrayStack<>(String.class);

        // 将10, 20, 30 依次推入栈中
        astack.push("10");
        astack.push("20");
        astack.push("30");

        // 将“栈顶元素”赋值给tmp，并删除“栈顶元素”
        tmp = astack.pop();
        System.out.println("tmp=" + tmp);

        // 只将“栈顶”赋值给tmp，不删除该元素.
        tmp = astack.peek();
        System.out.println("tmp=" + tmp);

        astack.push("40");
        astack.PrintArrayStack();    // 打印栈
    }
}
