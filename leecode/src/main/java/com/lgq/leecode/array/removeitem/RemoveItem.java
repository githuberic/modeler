package com.lgq.leecode.array.removeitem;

public class RemoveItem {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3, 4, 5, 6, 7};
        int val = 3;

        int len = removeElement(nums, val);
        System.out.println("新长度：" + len);
        System.out.print("数组内容：");
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeElement(int[] arr, int val) {
        int len = arr.length;
        int i = 0;

        while (i < len) {
            if (arr[i] == val) {
                arr[i] = arr[len - 1];
                len--;
            } else {
                i++;
            }
        }

        return len;
    }
}
