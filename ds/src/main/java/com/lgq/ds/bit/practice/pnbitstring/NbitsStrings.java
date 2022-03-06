package com.lgq.ds.bit.practice.pnbitstring;

import java.util.Arrays;

/**
 * @author lgq
 */
public class NbitsStrings {
    int[] arr;

    public NbitsStrings(int n) {
        arr = new int[n];
    }

    public void nBits(int n) {
        if (n <= 0) {
            System.out.println(Arrays.toString(arr));
        } else {
            arr[n - 1] = 0;
            nBits(n - 1);
            arr[n - 1] = 1;
            nBits(n - 1);
        }
    }
}
