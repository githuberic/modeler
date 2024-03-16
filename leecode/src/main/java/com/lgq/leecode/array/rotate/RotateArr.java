package com.lgq.leecode.array.rotate;

import java.util.Arrays;

/**
 * @author lgq
 */
public class RotateArr {

    public static void main(String[] args) {
        int[] arrNum = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(arrNum, k);
        System.out.println("轮转后的数组：" + Arrays.toString(arrNum));
    }

    private static void rotate(int[] arr, int k) {
        int len = arr.length;
        k %= len;

        // 整体反转
        reverse(arr, 0, len - 1);
        // 反转前k个元素
        reverse(arr, 0, k - 1);
        // 反转剩余的元素
        reverse(arr, k, len - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
