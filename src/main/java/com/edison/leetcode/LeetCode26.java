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
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] == nums[fast]) {
                // 如果相等的话
                // fast往后移
                continue;
            }
            // 直到找到不相等的 slow往前移到fast
            nums[++slow] = nums[fast];
        }
        return slow + 1;
    }

}
