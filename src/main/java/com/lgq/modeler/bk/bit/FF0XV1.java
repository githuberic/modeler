package com.lgq.modeler.bk.bit;

/**
 * Created by eric on 2019/12/28.
 *
 * @author lgq
 */
public class FF0XV1 {
    public static void main(String[] args) {
        byte[] arr = new byte[10];
        arr[0] = -127;
        print(arr[0]);
        print(0xFF);
        int a = arr[0] & 0XFF;
        print(a);
        print(0xFFFF);
    }

    private static void print(final int x) {
        System.out.println(String.format("十进制:%d", x));
        System.out.println(String.format("二进制:%s", Integer.toBinaryString(x)));
    }
}
