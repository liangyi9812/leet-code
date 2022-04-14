package com.edison.leetcode;

/**
 * @author LiangYi
 * @data 2022/4/12
 * @note
 */
public class LeetCode704 {

    public static int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int minValue = nums[mid];
            if (target == minValue) {
                return mid;
            } else if (target < minValue) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
