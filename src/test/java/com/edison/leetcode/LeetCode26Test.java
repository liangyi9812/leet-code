package com.edison.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LiangYi
 * @date 2022/4/13
 * @note
 */
class LeetCode26Test {

    @Test
    void removeDuplicates() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(LeetCode26.removeDuplicates(nums));
    }
}
