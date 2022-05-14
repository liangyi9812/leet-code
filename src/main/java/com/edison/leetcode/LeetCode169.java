package com.edison.leetcode;

import java.util.Arrays;

/**
 * @author LiangYi
 * @data 2022/4/17
 * @note
 */
public class LeetCode169 {

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] == nums[nums.length - 1]) {
            return nums[0];
        }
        int count = nums.length / 2;
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                if (fast - slow > count - 1) {
                    return nums[slow];
                }
                slow = fast;
            }
        }
        return -1;
    }

}
