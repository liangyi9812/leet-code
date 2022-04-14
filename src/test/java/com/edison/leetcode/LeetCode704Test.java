package com.edison.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author LiangYi
 * @data 2022/4/12
 * @note
 */
class LeetCode704Test {

    @Test
    void search() {
        int[] nums = {2, 5};
        int search = LeetCode704.search(nums, 5);
        System.out.println(search);
    }
}