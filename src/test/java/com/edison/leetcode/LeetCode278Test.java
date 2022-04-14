package com.edison.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LiangYi
 * @data 2022/4/13
 * @note
 */
class LeetCode278Test {

    @Test
    void firstBadVersion() {
        int version = 8;
        int i = LeetCode278.firstBadVersion(version);
        System.out.println(i);
    }
}