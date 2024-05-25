package com.edison.backpack;

/**
 * @author LiangYi
 * @date 2022/4/14
 * @note
 */
public class BackPack01 {

    /**
     * 物品重量：2 3 4 5 9
     * 物品价值：3 4 5 8 10
     *
     * 背包容量：20
     * @param w 物品重量
     * @param v 物品价值
     * @param bagWeight 背包容量
     * @return 最大价值
     */
    public static int maxValue(int[] w, int[] v, int bagWeight) {
        int[][] dp = new int[w.length + 1][bagWeight + 1];
        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= bagWeight; j++) {
                if (j < w[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return dp[w.length][bagWeight];
    }

}
