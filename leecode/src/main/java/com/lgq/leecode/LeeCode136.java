package com.lgq.leecode;

/**
 * 136. 只出现一次的数字)
 *
 * @author lgq
 */
public class LeeCode136 {
    public static int singleNumber(int[] nums) {
        int result = 0;
        // 异或：5^5=0，5^0=5，相同的数异或得到0，与0异或得到本身，所以把数组所有的数异或一遍，
        for (int i : nums) {
            result = result ^ i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }
}
