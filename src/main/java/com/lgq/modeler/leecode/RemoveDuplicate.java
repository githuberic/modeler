package com.lgq.modeler.leecode;

/***
 * 删除排序数组中的重复项
 * @author lgq
 */
public class RemoveDuplicate {
    public int remove(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[k] != arr[i]) {
                k++;
                arr[k] = arr[i];
            }
        }
        return k + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 6};
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        int length = removeDuplicate.remove(arr);
        System.out.println("length=" + length);
    }
}
