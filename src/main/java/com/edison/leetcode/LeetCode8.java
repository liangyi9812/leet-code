package com.edison.leetcode;

/**
 * @author LiangYi
 * @date 2022-7-10
 */
public class LeetCode8 {

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
    }

    public static int myAtoi(String s) {
        s = s.replaceAll("^\\s+", "");
        if (s.length() == 0) {
            return 0;
        }
        boolean positive = s.charAt(0) != '-';
        int index = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0;
        long res = 0L;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            char charAt = s.charAt(index++);
            res = res * 10 + (charAt - '0');
            if (positive) {
                if (res > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            } else {
                if (-res < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
        }
        return positive ? (int) res : (int) -res;
    }

}
