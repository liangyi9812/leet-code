package com.edison.leetcode;

/**
 * @author LiangYi
 * @data 2022/4/13
 * @note
 */
public class LeetCode27 {

    /**
     * {0,1,2,2,3,0,4,2}
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            int fastValue = nums[fast];
            if (fastValue == val) {
                continue;
            } else {
                nums[slow] = fastValue;
            }
            if (nums[slow] != val) {
                slow++;
            }
        }
        return slow;
    }

}
