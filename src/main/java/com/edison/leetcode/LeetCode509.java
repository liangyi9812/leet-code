package com.edison.leetcode;

/**
 * @author LiangYi
 * @date 2022/4/14
 */

public class LeetCode509 {

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int fib3(int n) {
        int[] dp = new int[2];
        dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            dp[i % 2] = dp[0] + dp[1];
        }
        return dp[n % 2];
    }
}
