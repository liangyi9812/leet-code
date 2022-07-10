package com.edison.leetcode;

import java.util.HashMap;

/**
 * @author LiangYi
 * @date 2022-7-9
 */
public class LeetCode242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int index = 0;
        while (index < s.length()) {
            char c1 = s.charAt(index);
            char c2 = t.charAt(index);
            hashMap.compute(c1, (k, v) -> v == null ? 1 : v + 1);
            hashMap.compute(c2, (k, v) -> v == null ? -1 : v - 1);
            index++;
        }
        return hashMap.values().stream().allMatch(i -> i == 0);
    }

}
