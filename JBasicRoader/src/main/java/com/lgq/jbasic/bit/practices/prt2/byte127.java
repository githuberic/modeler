package com.lgq.jbasic.bit.practices.prt2;

/**
 * @author lgq
 */
public class byte127 {
    public static void main(String[] args) {
        byte[] a = new byte[10];
        a[0] = -127;
        System.out.println(a[0]);
        // 打印a[0]&0xff后的值，本来我想结果应该都是-127.
        int c = a[0] & 0xff;
        System.out.println(c);
    }
}
