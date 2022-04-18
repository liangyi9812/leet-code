package com.edison.leetcode;

/**
 * @author LiangYi
 * @date 2022/4/18
 */
public class LeetCode303 {

    static class NumArray {

        private int[] source;

        public NumArray(int[] nums) {
            source = nums;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += source[i];
            }
            return sum;
        }
    }

}
