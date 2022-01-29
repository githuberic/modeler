package com.lgq.jroader.bit.lesson1;

/**
 * @author lgq
 */
public class Lesson1_2 {
    /**
     * 向左移位
     *
     * @param num num-等待移位的十进制数,
     * @param m   m-向左移的位数
     * @return int-移位后的十进制数
     */
    public static int leftShift(int num, int m) {
        return num << m;
    }

    /**
     * 向右移位
     *
     * @param num num-等待移位的十进制数,
     * @param m   m-向右移的位数
     * @return int-移位后的十进制数
     */
    public static int rightShift(int num, int m) {
        return num >>> m;
    }


    public static void main(String[] args) {
        int num = 53;
        int m = 1;
        System.out.println(String.format("数字%d的二进制向左移%d位是%d", num, m, Lesson1_2.leftShift(num, m)));   //测试向左移位
        System.out.println(String.format("数字%d的二进制向右移%d位是%d", num, m, Lesson1_2.rightShift(num, m)));   //测试向右移位

        System.out.println();

        m = 3;
        System.out.println(String.format("数字%d的二进制向左移%d位是%d", num, m, Lesson1_2.leftShift(num, m)));   //测试向左移位
        System.out.println(String.format("数字%d的二进制向右移%d位是%d", num, m, Lesson1_2.rightShift(num, m)));   //测试向右移位
    }
}
