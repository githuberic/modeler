package com.lgq.ds.bit.practice.pmissingduplicate;

/**
 * @author lgq
 */
public class MissingDuplicate {
    // naive solution is use Hash Table ..space complexity – O(n)
    // better solutiion – XOR
    // A^A = 0 and A^B^A = B, so if we XOR all the elements, answer will be the
    // missing no
    public int find(int[] A) {
        // if we have only one element, the missing no will be that no
        int miss = A[0];
        for (int i = 1; i < A.length; i++) {
            miss = miss ^ A[i];
        }
        return miss;
    }
}
