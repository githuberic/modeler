package com.lgq.modeler.leecode;

/**
 * 167. 两数之和 II - 输入有序数组)
 *
 * @author lgq
 * https://github.com/azl397985856/leetcode/blob/master/problems/167.two-sum-ii-input-array-is-sorted.md
 */
public class LeeCode167 {
    public static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if ((nums[left] + nums[right]) > target) {
                right--;
            } else {
                left--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] arrResult = twoSum(nums, 9);
        for (int i : arrResult) {
            System.out.println(String.format("Index=%d,Value=%d", i, nums[--i]));
        }
    }
}
