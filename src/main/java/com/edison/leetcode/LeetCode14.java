package com.edison.leetcode;

/**
 * @author LiangYi
 * @date 2022-7-11
 */
public class LeetCode14 {


    public static String longestCommonPrefix(String[] strs) {
        int index = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (String str : strs) {
                if (index > str.length() - 1 || str.charAt(index) != strs[0].charAt(index)) {
                    return str.substring(0, index);
                }
            }
            index++;
        }
        return strs[0];
    }
}
