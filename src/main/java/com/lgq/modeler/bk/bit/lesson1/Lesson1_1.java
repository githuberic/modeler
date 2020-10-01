package com.lgq.modeler.bk.bit.lesson1;

import java.math.BigInteger;

/**
 * @author lgq
 */
public class Lesson1_1 {
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

    public static int binaryToDecimal(String binarySource) {
        //转换为BigInteger类型，参数2指定的是二进制
        BigInteger bigInteger = new BigInteger(binarySource, 2);
        //默认转换成十进制
        return Integer.parseInt(bigInteger.toString());
    }

    public static void main(String[] args) {
        int a = 53;
        String b = "110101";
        System.out.println(String.format("数字%d的二进制是%s", a, Lesson1_1.decimalToBinary(a))); //获取十进制数53的二进制数
        System.out.println(String.format("数字%s的十进制是%d", b, Lesson1_1.binaryToDecimal(b))); //获取二进制数110101的十进制数
    }
}
