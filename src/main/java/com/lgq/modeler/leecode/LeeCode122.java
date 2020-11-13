package com.lgq.modeler.leecode;

/**
 * 122. 买卖股票的最佳时机 II)
 *
 * @author lgq
 */
public class LeeCode122 {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit +=prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }
}
