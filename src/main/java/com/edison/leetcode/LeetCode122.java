package com.edison.leetcode;

/**
 * @author LiangYi
 * @date 2022-7-8
 */
public class LeetCode122 {

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], Math.max(dp[i - 1][0], dp[i - 1][1]) - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

}
