package com.edison.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author LiangYi
 * @data 2022/4/13
 * @note
 */
class LeetCode27Test {

    @Test
    void removeElement() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(LeetCode27.removeElement(nums, 2));
    }
}