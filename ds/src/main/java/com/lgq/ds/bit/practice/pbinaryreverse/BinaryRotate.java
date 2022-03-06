package com.lgq.ds.bit.practice.pbinaryreverse;

/**
 * @author lgq
 */
public class BinaryRotate {
    public int rotateBinary(int number) {
        int res = 0;
        while (number > 0) {
            res = res << 1;
            res = res | (number & 1);
            number = number >> 1;
        }
        return res;
    }
}
