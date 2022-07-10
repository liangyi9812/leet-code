package com.edison.leetcode;

import java.util.Arrays;

/**
 * @author LiangYi
 * @date 2022-7-8
 */
public class LeetCode66 {

    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 9};
        System.out.println(Arrays.toString(plusOne(nums)));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        // all 9
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

}
