package com.edison.leetcode;

/**
 * @author LiangYi
 * @date 2022/4/15
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
     * <p>
     * dp[i][0]：规定了今天不持股，有以下两种情况：
     * <p>
     * 昨天不持股，今天什么都不做；
     * 昨天持股，今天卖出股票（现金数增加），
     * dp[i][1]：规定了今天持股，有以下两种情况：
     * <p>
     * 昨天持股，今天什么都不做（现金数与昨天一样）；
     * 昨天不持股，今天买入股票（注意：只允许交易一次，因此手上的现金数就是当天的股价的相反数）。
     *
     * @param prices
     * @return
     */
    public static int maxProfitV2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
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
