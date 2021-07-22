package com.lgq.ds.sort;

import java.util.Arrays;

/**
 * Created by eric on 2018/12/31.
 *
 * @author shaofeng
 */
public class InsertionSort {
    public void sort(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        int length = arr.length;
        for (int i = 1; i < length; ++i) {
            int j = i - 1;
            // temp是本趟待插入的数，之前从0~i-1的数全是从左→右有序递增。
            int temp = arr[i];
            for (; j >= 0; --j) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            // 插入数据
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 3, 10, 0, 6};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
/**
 * 1:原始数组:7, 3, 10, 0, 6
 * 2:第一步 j=0; temp = 3, arr[j] = 7, ->  arr[1]=7,
 * 3:
 * 4:
 * 5:
 * 6:
 */
