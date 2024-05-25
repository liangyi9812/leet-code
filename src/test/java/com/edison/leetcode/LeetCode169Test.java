package com.edison.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author LiangYi
 * @date 2022/4/17
 * @note
 */
class LeetCode169Test {

    @Test
    void majorityElement() {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        assertEquals(3, LeetCode169.majorityElement(nums));
    }
}
