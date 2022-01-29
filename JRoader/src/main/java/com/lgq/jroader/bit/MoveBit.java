package com.lgq.jroader.bit;

/**
 * Created by eric on 2019/11/5.
 *
 * @author lgq
 */
public class MoveBit {
    public static void main(String[] args) {
        System.out.println(">>>Move bit===");
        int number = 10;
        // 二进制输出
        System.out.println(String.format("二进制:%s",Integer.toBinaryString(number)));

        // 左移相当于*2 = 10*2 = 20
        number = number << 1;
        System.out.println(Integer.toBinaryString(number));

        // 此是number = 20,
        // 右移相当于/2 = 20/2 = 10
        number = number >> 1;
        System.out.println(Integer.toBinaryString(number));

        // >>>是无符号右移,将运算符左边的对象向右移动运算符右边指定的数，并且在高位补0，其实右移n位，就相当于除于2的n此方；
        System.out.println(">>>Move(无符号) bit===");
        int a = 16;
        System.out.println(Integer.toBinaryString(a));
        int b = 2;
        System.out.println(Integer.toBinaryString(b));
        int c = a >>> b;
        System.out.println(Integer.toBinaryString(c));

        // >>带符号右移运算符，它表示将运算符左边的运算对象，向右移动运算符右边指定的位数。如果是正数，在高位补零，如果是负数，则在高位补1；
        System.out.println("Move(带符号-右移) bit >>");
        a = 16;
        b = 2;
        c = a >> b;
        System.out.println(String.format("二进制:%s", Integer.toBinaryString(c)));

        a = -16;
        b = 2;
        c = a >> b;
        System.out.println(String.format("二进制:%s", Integer.toBinaryString(c)));
        System.out.println(String.format("十进制:%d", c));

        //<< --- 左移运算符，它表示是将运算符左边的对象，向左移动运算符右边指定的位数，并且在低位补零。其实，向左移n位，就相当于乘上2的n此方；
        System.out.println("Move(带符号-左移) bit <<");
        a = 2;
        b = 3;
        c = a << b;
        System.out.println(String.format("二进制:%s", Integer.toBinaryString(c)));
        System.out.println(String.format("十进制:%d", c));
    }
}
