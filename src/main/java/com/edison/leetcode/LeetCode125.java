package com.edison.leetcode;

/**
 * @author LiangYi
 * @date 2022-7-9
 */
public class LeetCode125 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("Damosel, a poem? A carol? Or a cameo pale? (So mad!)"));
    }

    public static boolean isPalindrome(String s) {
        String afterReg = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = afterReg.length() - 1;
        while (left < right) {
            if (afterReg.charAt(left++) != afterReg.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

}
