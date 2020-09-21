package com.lgq.modeler.ds.sort;

/**
 * Created by eric on 2019/1/1.
 *
 * @author shaofeng
 */
public class MergeSortV2 {
    /**
     * 使用分治方式进行排序
     *
     * @param arr   原始数组
     * @param tmp   临时数组
     * @param start 指定排序的开始位置
     * @param end   指定排序的结束位置
     */
    private static void sort(int[] arr, int[] tmp, int start, int end) {
        //递归结束条件，就是数组索引从头到尾遍历完毕。
        if (start >= end) {
            return;
        }
        //分治思想递归实现
        //递归公式：merge(start...end)=merge(start...mid),merge(mid+1...end)
        int mid = (start + end) / 2;
        sort(arr, tmp, start, mid);
        sort(arr, tmp, mid + 1, end);
        //开始合并分治后的结果
        merge(arr, tmp, start, mid, end);
    }

    /**
     * 开始合并分治后的结果
     *
     * @param arr   原始数组
     * @param tem   临时数组
     * @param start 开始排序的元素位置
     * @param mid   元素中间位置
     * @param end   指定排序的结束位置
     */
    private static void merge(int[] arr, int[] tem, int start, int mid, int end) {
        //k用来进行标记临时数组的下标
        //进行拷贝原来的数据
        for (int k = start; k <= end; k++) {
            tem[k] = arr[k];
        }

        //将数据拷贝会原来的数组
        int x = start;
        int y = mid + 1;
        for (int k = start; k <= end; k++) {
            //判断分出的第一个数组是否越界
            if (x > mid) {
                arr[k] = tem[y];
                y++;
            }
            //判断分出的第二个数组是否越界
            else if (y > end) {
                arr[k] = tem[x++];
                x++;
            }
            //真正开始比较两个元素大小
            else if (tem[y] < tem[x]) {
                arr[k] = tem[y];
                y++;
            } else {
                arr[k] = tem[x];
                x++;
            }
        }
    }
}
