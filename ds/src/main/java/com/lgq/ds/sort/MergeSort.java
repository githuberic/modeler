package com.lgq.ds.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 归并排序分析：
 * 1. 原理：对半递归拆分数组，将每个拆分后的数组一一合并，合并时进行排序。
 * 2. 执行效率：最好、最坏和平均都是O（nlogn）。这里有个计算递归时间复杂度的一个技巧：T(n) = T(n/2) + T(n/2) + n, 继续分解后 T(n) = 2^k*(T(n/2^k)) + k*n, k = logn其他可以忽略不计。
 * 3. 内存消耗：因为在合并结果时需要临时开辟数组，所以是O(n)， 不能和时间复杂度混为一谈，临时数组内存空间是会在函数结束后被回收的，因此取最大的即可。
 * 5. 稳定。
 * Created by eric on 2019/1/1.
 *
 * @author shaofeng
 */
public class MergeSort {
    public int[] sort(int[] array) {
        if (array.length < 2) {
            return array;
        }

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        return merge(sort(left), sort(right));
    }

    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 3, 10, 1, 6};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array);
        int[] arrSort = mergeSort.sort(array);
        System.out.println(Arrays.toString(arrSort));
    }
}
