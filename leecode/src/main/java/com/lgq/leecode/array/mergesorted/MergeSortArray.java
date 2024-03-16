package com.lgq.leecode.array.mergesorted;

public class MergeSortArray {

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;

        int[] num2 = new int[]{4, 5, 6};
        int n = 3;

        merge(num1, m, num2, n);

        for (int item : num1) {
            System.out.print(item + ",");
        }
    }

    public static void merge(int[] num1, int n, int[] num2, int m) {
        int p1 = n - 1;
        int p2 = m - 1;
        int p = n + m - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (num1[p1] > num2[p2]) {
                num1[p] = num1[p1];
                p1--;
            } else {
                num1[p] = num2[p2];
                p2--;
            }
            p--;
        }
        while (p2 >= 0) {
            num1[p] = num2[p2];
            p2--;
            p--;
        }
    }
}
