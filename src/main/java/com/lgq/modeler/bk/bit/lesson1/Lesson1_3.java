package com.lgq.modeler.bk.bit.lesson1;

import java.math.BigInteger;

/**
 * @author lgq
 */
public class Lesson1_3 {

    public static int or(int num1, int num2) {
        return (num1 | num2);
    }

    public static int and(int num1, int num2) {
        return (num1 & num2);
    }

    public static int xor(int num1, int num2) {
        return (num1 ^ num2);
    }


    public static void main(String[] args) {

        int a = 53;
        int b = 35;

        System.out.println(String.format("数字%d(%s)和数字%d(%s)的按位‘或’结果是%d(%s)",
                a, decimalToBinary(a), b, decimalToBinary(b), Lesson1_3.or(a, b), decimalToBinary(Lesson1_3.or(a, b)))); //获取十进制数53和35的按位“或”

        System.out.println(String.format("数字%d(%s)和数字%d(%s)的按位‘与’结果是%d(%s)",
                a, decimalToBinary(a), b, decimalToBinary(b), Lesson1_3.and(a, b), decimalToBinary(Lesson1_3.and(a, b))));  //获取十进制数53和35的按位“与”

        System.out.println(String.format("数字%d(%s)和数字%d(%s)的按位‘异或’结果是%d(%s)",
                a, decimalToBinary(a), a, decimalToBinary(a), Lesson1_3.xor(a, a), decimalToBinary(Lesson1_3.xor(a, a))));  //获取十进制数53和35的按位“异或”

    }

    /**
     * 十进制转换成二进制
     *
     * @param decimalSource
     * @return
     */
    private static String decimalToBinary(int decimalSource) {
        BigInteger bigInteger = new BigInteger(String.valueOf(decimalSource));
        return bigInteger.toString(2);
    }

}
