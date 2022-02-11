package com.lgq.jbasic.bit.example.e2;

import org.junit.Test;

import java.math.BigInteger;

/**
 * @author lgq
 */
public class BitCalc {
    private int or(int num1, int num2) {
        return (num1 | num2);
    }

    private int and(int num1, int num2) {
        return (num1 & num2);
    }

    private int xor(int num1, int num2) {
        return (num1 ^ num2);
    }

    /**
     * 十进制转换成二进制
     *
     * @param decimalSource
     * @return
     */
    private String decimalToBinary(int decimalSource) {
        BigInteger bigInteger = new BigInteger(String.valueOf(decimalSource));
        return bigInteger.toString(2);
    }

    @Test
    public void testCalc() {
        int a = 53;
        int b = 35;

        System.out.println(String.format("数字%d(%s)和数字%d(%s)的按位‘或’结果是%d(%s)",
                a, decimalToBinary(a), b, decimalToBinary(b), or(a, b), decimalToBinary(or(a, b)))); //获取十进制数53和35的按位“或”

        System.out.println(String.format("数字%d(%s)和数字%d(%s)的按位‘与’结果是%d(%s)",
                a, decimalToBinary(a), b, decimalToBinary(b), and(a, b), decimalToBinary(and(a, b))));  //获取十进制数53和35的按位“与”

        System.out.println(String.format("数字%d(%s)和数字%d(%s)的按位‘异或’结果是%d(%s)",
                a, decimalToBinary(a), a, decimalToBinary(a), xor(a, a), decimalToBinary(xor(a, a))));  //获取十进制数53和35的按位“异或”
    }
}
