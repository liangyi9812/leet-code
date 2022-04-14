package com.edison.leetcode;

/**
 * @author LiangYi
 * @data 2022/4/13
 * @note
 */
public class LeetCode35 {

    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int midValue = nums[mid];
            if (midValue < target) {
                left = mid + 1;
            } else if (target < midValue) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return right + 1;
    }

}
