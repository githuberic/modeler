package com.lgq.modeler.ds.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 快排分析：
 * 1. 原理：取一个基数，一般是最后一位，然后遍历前面的数，比其小的数在左边，否则在右边，最后将基数放到分区位，递归排序左右两部分。
 * 2. 执行效率：最好O（nlogn），最坏O（n^2），平均是O（nlogn）。最坏的情况是取最后一位为基数而这个列表已经排序好了。
 * 3. 内存消耗：原地排序O（1），这也是为什么快排比归并更受欢迎
 * 5. 不稳定。
 * Created by eric on 2018/9/20.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 8, 7, 6, 5, 3, 9, 0};
        //System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        if (arr.length > 0) {
            quickSort(arr, 0, arr.length - 1);
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        // 1:找到递归算法的出口
        if (low > high) {
            return;
        }

        int flag = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i < j && arr[j] > flag) {
                j--;
            }
            while (i < j && arr[i] <= flag) {
                i++;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i];
        arr[i] = arr[low];
        arr[low] = temp;

        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }
}
