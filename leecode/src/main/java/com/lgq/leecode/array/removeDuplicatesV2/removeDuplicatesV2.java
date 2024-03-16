package com.lgq.leecode.array.removeDuplicatesV2;

/**
 * @author lgq
 */
public class removeDuplicatesV2 {

    public static void main(String[] args) {
        // 输入数组
        int[] nums = {1, 1, 1, 2, 2, 3};
        // 长度正确的期望答案
        int[] expectedNums = {1, 1, 2, 2, 3};

        // 调用
        int k = removeDuplicate(nums);

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }

        System.out.println("删除重复项后的新长度为: " + k);
        System.out.print("删除重复项后的数组为: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static int removeDuplicate(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }

        // 慢指针从第3个元素开始
        int k = 2;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != arr[k - 2]) {
                arr[k] = arr[i];
                k++;
            }
        }
        return k;
    }
}
