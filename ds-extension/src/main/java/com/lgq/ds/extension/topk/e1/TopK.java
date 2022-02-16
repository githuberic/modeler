package com.lgq.ds.extension.topk.e1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author lgq
 */
public class TopK {
    /**
     * 取最小的k个数
     */
    public static int[] getTopKByPartition(int[] arr, int k) {
        if (arr == null || arr.length <= 0 || k <= 1) {
            return null;
        }

        int size = arr.length;
        int target = k;

        int low = 0;
        int high = size - 1;

        int mid = getMid(arr, low, high);
        while (mid != target) {
            if (mid < target) {
                mid = getMid(arr, mid + 1, high);
            } else {
                mid = getMid(arr, low, mid - 1);
            }
        }

        int[] ret = new int[target];
        System.arraycopy(arr, 0, ret, 0, target);
        return ret;
    }

    /**
     * 快排思想-一趟排序
     */
    private static int getMid(int[] arr, int low, int high) {
        int base = arr[low];
        while (low < high) {
            // 判断条件必须加=场景，为<= 不能为<，否则数组中有相同数据时，会一直循环
            while (low < high && base <= arr[high]) {
                high--;
            }
            arr[low] = arr[high];

            // 判断条件必须加=场景，为>= 不能为>，否则数组中有相同数据时，会一直循环
            while (low < high && base >= arr[low]) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = base;
        return low;
    }

    /**
     * 堆排序，组建一个(size+1)/2大小的最大堆 ，取到top (size+1)/2个小的值，则堆顶元素即为中位数
     * <p>
     * 先取前(size+1)/2个元素，组成最大堆，剩下的元素和堆顶比较，比堆顶大则忽略，比堆顶小则交换，然后重组最大堆
     */
    public static Queue<Integer> getTopKByMaxHeap(int[] arr, int k) {
        if (arr == null || arr.length <= 0 || k <= 1) {
            return null;
        }

        // 初步组建最大堆
        int heapSize = k;

        // JDK1.7 需指定初始大小，内部实现了最大堆(实现自定义从大到小排序)
        PriorityQueue<Integer> queue = new PriorityQueue<>(heapSize, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < heapSize; i++) {
            queue.offer(arr[i]);
        }

        // 比较余下元素，比堆顶小则替换堆顶元素为新值
        int size = arr.length;
        for (int j = heapSize; j < size; j++) {
            int temp = arr[j];
            // 当前元素比堆顶大 则删除堆顶元素，把当前元素加入堆
            if (queue.peek() > temp) {
                queue.poll();
                queue.offer(temp);
            }
        }

        // 返回堆顶元素
        return queue;
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2, 0, 3, 7, 8, 9, 10, 1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(getTopKByPartition(arr, 10)));


        int[] arr2 = {4, 5, 6, 1, 2, 0, 3, 7, 8, 9, 10, 1, 1, 1, 1, 1, 1};
        System.out.println(getTopKByMaxHeap(arr2, 10));
    }
}
