package com.edison.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiangYi
 * @date 2022-7-8
 */
public class LeetCode217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

}
