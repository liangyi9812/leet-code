package com.edison.leetcode;

/**
 * @author LiangYi
 * @data 2022/4/13
 * @note
 */
public class LeetCode26 {

    /**
     * {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[slow]) {
                slow++;
                nums[slow] = nums[i];
            }
        }
        return slow + 1;
    }

}
