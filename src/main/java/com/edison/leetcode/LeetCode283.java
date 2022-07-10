package com.edison.leetcode;

/**
 * @author LiangYi
 * @date 2022-7-9
 */
public class LeetCode283 {

    public static void moveZeroes(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            nums[slow++] = nums[i];
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
