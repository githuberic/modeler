package com.lgq.modeler.leecode;

/**
 * 53. 最大子序和
 *
 * @author lgq
 */
public class LeeCode53 {
    public static int maxSubArray(int[] arr) {
        //贪心
        int curSum = Integer.MIN_VALUE;//当前和
        int maxSum = Integer.MIN_VALUE;//最大和
        for (int num : arr) {
            if (curSum <= 0) {
                //如果当前元素的前面元素的和小于或等于0，舍弃
                //从当前元素重新计算
                curSum = num;
            } else {
                //如果前面元素的和大于0，那么就再加上当前元素
                curSum += num;
            }
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    /**
     * 动态规划
     *
     * @param arr
     * @return
     */
    public static int maxSubArrayV2(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //如果新数组的前一个数小于0，那么直接把原数组对应位置的值放到新数组中
            if (dp[i - 1] < 0) {
                dp[i] = arr[i];
            } else {
                //新数组的前一个元素大于0，和原数组对应位置的值相加后放到新数组中
                dp[i] = dp[i - 1] + arr[i];
            }
            //比较最大值
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArrayV2(arr));
    }
}
