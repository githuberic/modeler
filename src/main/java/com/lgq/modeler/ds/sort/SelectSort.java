package com.lgq.modeler.ds.sort;

import java.util.Arrays;

/**
 * Created by eric on 2018/3/9.
 *
 * @author shaofeng
 */
public class SelectSort {
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return;
        }

        int index;
        for (int i = 0; i < arr.length; i++) {
            index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{7, 3, 10, 0, 6};
        SelectSort selectSort = new SelectSort();
        selectSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
