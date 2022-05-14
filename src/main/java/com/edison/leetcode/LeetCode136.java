package com.edison.leetcode;

import java.util.Arrays;

/**
 * @author LiangYi
 * @data 2022/4/17
 * @note
 */
public class LeetCode136 {

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }

    public static int singleNumberV2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            // 异或
            single ^= num;
        }
        return single;
    }

}
