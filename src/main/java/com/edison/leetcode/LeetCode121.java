package com.edison.leetcode;

/**
 * @author LiangYi
 * @data 2022/4/15
 * @note
 */
public class LeetCode121 {

    /**
     * 暴力
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int max = Integer.MIN_VALUE;
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                max = Math.max(prices[i] - prices[j], max);
            }
        }
        return Math.max(max, 0);
    }

    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public static int maxProfitV2(int[] prices) {
        int days = prices.length;
        int[][] dp = new int[days][2];
        // 初始化
        // 当天结束时不持股
        dp[0][0] = 0;
        // 当天结束时持股
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[days - 1][0];
    }

    public static int maxProfitV3(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}