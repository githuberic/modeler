package com.lgq.leecode;

/**
 * 169. 多数元素
 *
 * @author lgq
 * from https://github.com/azl397985856/leetcode/blob/master/problems/169.majority-element.md
 */
public class LeeCode169 {
    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int cur = nums[0], count = 0;
        for (int num : nums) {
            if (num != cur) {
                count--;
                if (count == 0) {
                    count = 1;
                    cur = num;
                }
            } else {
                count++;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        System.out.println(majorityElement(nums));
    }
}
