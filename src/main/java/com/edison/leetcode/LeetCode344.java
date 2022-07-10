package com.edison.leetcode;

/**
 * @author LiangYi
 * @date 2022-7-9
 */
public class LeetCode344 {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

}
