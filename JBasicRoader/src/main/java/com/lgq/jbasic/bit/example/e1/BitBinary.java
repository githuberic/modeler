package com.lgq.jbasic.bit.example.e1;

import org.junit.Test;

/**
 * @author lgq
 */
public class BitBinary {
    @Test
    public void testBit() {
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
    }
}
