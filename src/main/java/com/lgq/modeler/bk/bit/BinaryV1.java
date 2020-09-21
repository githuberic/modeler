package com.lgq.modeler.bk.bit;

/**
 * Created by eric on 2019/11/5.
 */
public class BinaryV1 {
    public static void main(String[] args) {
        int x;
        // 0x01=16进制 = 1*16^0 + 0*16^1
        int x01 = 0x01;
        System.out.println("x01=" + x01);

        // 0x02=16进制 = 2*16^0 + 0*16^1
        int x02 = 0x02;
        System.out.println("x02=" + x02);

        int x04 = 0x04;
        System.out.println("x04=" + x04);

        int x08 = 0x08;
        System.out.println("x08=" + x08);

        int x10 = 0x10;
        System.out.println("x10=" + x10);

        int x20 = 0x20;
        System.out.println("x20=" + x20);

        int x40 = 0x40;
        System.out.println("x40=" + x40);

        int y = x01 | x02;
        System.out.println("Binary=" + Integer.toBinaryString(y) + ",10=" + y);

        int y1 = y & x01;
        System.out.println("Binary=" + Integer.toBinaryString(y1) + ",10=" + y1);

        int y2 = y & x02;
        System.out.println("Binary=" + Integer.toBinaryString(y2) + ",10=" + y2);
    }
}
