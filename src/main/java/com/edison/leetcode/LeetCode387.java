package com.edison.leetcode;

import java.util.HashMap;

/**
 * @author LiangYi
 * @date 2022-7-9
 */
public class LeetCode387 {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            map.compute(ch, (k, v) -> v == null ? 1 : v + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

}
