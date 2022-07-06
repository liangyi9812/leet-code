package com.edison.leetcode;

/**
 * @author LiangYi
 * @data 2022/4/13
 * @note
 */
public class LeetCode53 {

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
    }
    /**
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int max = nums[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

}
