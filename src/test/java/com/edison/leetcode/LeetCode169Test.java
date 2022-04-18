package com.edison.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author LiangYi
 * @date 2022/4/18
 */
class LeetCode169Test {


    @Test
    void majorityElement() {
        int[] nums = {2, 3, 2, 1, 3, 1, 1, 3, 3, 2, 2, 3};
        System.out.println(LeetCode169.majorityElement(nums));
    }
}