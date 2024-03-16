package com.lgq.leecode.array.removeDuplicates;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arrNum = new int[]{1, 2, 2, 4, 5};

        int k = removeDuplicates(arrNum);
        System.out.println("新数组的长度:" + k);
        System.out.println("新数组内容:");
        for (int i = 0; i < k; i++) {
            System.out.print(arrNum[i] + ",");
        }
    }

    public static int removeDuplicates(int[] arr) {
        int len = arr.length;
        int k = 1;

        for (int i = 1; i < len; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[k] = arr[i];
                k++;
            }
        }
        return k;
    }
}
