package com.lgq.modeler.ds.sort;

import java.util.Arrays;

/**
 * 冒泡排序,基本思想是：
 * 对相邻的元素进行两两比较，顺序相反则进行交换，
 * 每一轮会将最小或最大的元素"浮"到顶端，最终达到完全有序
 * <p>
 * Created by eric on 2018/12/31.
 *
 * @author shaofeng
 */
public class
BubbleSort {
    public void sort(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        int length = arr.length;
        // 共n轮排序,每轮都是把最大的元素排在后面
        for (int i = 0; i < length - 1; i++) {
            // 每轮排序中:需要比较的元素个数比上一轮少一个
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 3, 10, 0, 6};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
