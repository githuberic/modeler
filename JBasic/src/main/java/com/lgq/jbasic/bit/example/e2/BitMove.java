package com.lgq.jbasic.bit.example.e2;

import org.junit.Test;

/**
 * @author lgq
 */
public class BitMove {
    /**
     * 向左移位
     *
     * @param num num-等待移位的十进制数,
     * @param m   m-向左移的位数
     * @return int-移位后的十进制数
     */
    private int leftShift(int num, int m) {
        return num << m;
    }

    /**
     * 向右移位
     *
     * @param num num-等待移位的十进制数,
     * @param m   m-向右移的位数
     * @return int-移位后的十进制数
     */
    private int rightShift(int num, int m) {
        return num >>> m;
    }

    @Test
    public void testMove() {
        int num = 53;
        int m = 2;
        System.out.println(String.format("数字%d的二进制向左移%d位是%d", num, m, leftShift(num, m)));   //测试向左移位
        System.out.println(String.format("数字%d的二进制向右移%d位是%d", num, m, rightShift(num, m)));   //测试向右移位
    }
}
