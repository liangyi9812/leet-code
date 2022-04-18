package com.edison.leetcode;

import java.util.Arrays;

/**
 * @author LiangYi
 * @date 2022/4/18
 */
public class LeetCode169 {

    /**
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] == nums[nums.length - 1]) {
            return nums[0];
        }
        int count = nums.length / 2;
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                if (((fast == nums.length - 1) ? fast + 1 : fast) - slow > count) {
                    return nums[slow];
                }
                slow = fast;
            }
        }
        return nums[slow] == nums[nums.length - 1] ? nums[slow] : -1;
    }

}
