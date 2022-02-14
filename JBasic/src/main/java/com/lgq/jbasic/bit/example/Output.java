package com.lgq.jbasic.bit.example;

/**
 * @author lgq
 */
public class Output {
    public static void print(final int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("十进制=%d,", num));
        sb.append(String.format("二进制:%s", Integer.toBinaryString(num)));
        System.out.println(sb);
    }
}
