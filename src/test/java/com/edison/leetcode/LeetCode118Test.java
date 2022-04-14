package com.edison.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LiangYi
 * @data 2022/4/15
 * @note
 */
class LeetCode118Test {

    @Test
    void generate() {
        List<List<Integer>> generate = LeetCode118.generateV2(4);
        System.out.println(generate);
    }
}