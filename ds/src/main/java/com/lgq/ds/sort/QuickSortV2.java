package com.lgq.ds.sort;

import java.util.Arrays;

/**
 * @author lgq
 */
public class QuickSortV2 {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int q = partition(arr, start, end);
        sort(arr, start, q - 1);
        sort(arr, q + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    int temp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        return i;
    }

    public static void main(String[] args) {
        QuickSortV2 quickSortV2 = new QuickSortV2();
        int[] arr = new int[]{1, 2, 4, 8, 7, 6, 5, 3, 9, 0};
        //System.out.println(Arrays.toString(arr));
        quickSortV2.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
