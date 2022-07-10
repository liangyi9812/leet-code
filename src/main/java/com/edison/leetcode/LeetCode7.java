package com.edison.leetcode;

/**
 * @author LiangYi
 * @date 2022-7-9
 */
public class LeetCode7 {

    public static void main(String[] args) {
        System.out.println(reverse(1899999999));
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

}
