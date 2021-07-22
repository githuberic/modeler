package com.lgq.ds.sort;

import java.util.Arrays;

/**
 * @author lgq
 */
public class MergeSortV3 {

    public void sort(int[] array) {
        mergeSortInternal(array, 0, array.length - 1);
    }

    private void mergeSortInternal(int[] arr, int p, int r) {
        // 递归终止条件
        if (p >= r) {
            return;
        }

        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p + (r - p) / 2;
        // 分治递归
        mergeSortInternal(arr, p, q);
        mergeSortInternal(arr, q + 1, r);

        merge(arr, p, q, r);
    }

    private void merge(int[] arr, int p, int q, int r) {
        // 初始化变量i, j, k
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = arr[start++];
        }

        for (i = 0; i <= (r - p); ++i) {
            arr[p + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{6, 5, 10, 2, 9};
        MergeSortV3 mergeSort = new MergeSortV3();
        mergeSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
