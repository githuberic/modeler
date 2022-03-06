package com.lgq.ds.bit.practice.pbinaryreverse;

import org.junit.Test;

/**
 * @author lgq
 */
public class BinaryRotateTest {
    @Test
    public void testReverseBinary(){
        int x =30;
        BinaryRotate b = new BinaryRotate();
        System.out.println("Binary rotation of "+ x + " is : " + b.rotateBinary(x));
    }
    // https://algorithms.tutorialhorizon.com/reverse-the-binary-representation-of-a-number/
}
