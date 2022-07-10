package com.edison.leetcode;

/**
 * @author LiangYi
 * @date 2022-7-10
 */
public class LeetCode28 {

    public static void main(String[] args) {
        System.out.println(strStr("aabaadaaf", "aadaaf"));
    }

    public static int strStr(String ms, String ps) {
        int[] next = getNext(ps);
        int j = 0;
        for (int i = 0; i < ms.length(); i++) {
            while (j != 0 && ms.charAt(i) != ps.charAt(j)) {
                j = next[j - 1];
            }
            if (ms.charAt(i) == ps.charAt(j)) {
                j++;
            }
            if (j == ps.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private static int[] getNext(String ps) {
        int[] next = new int[ps.length()];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < ps.length(); i++) {
            while (j != 0 && ps.charAt(i) != ps.charAt(j)) {
                j = next[j - 1];
            }
            if (ps.charAt(i) == ps.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }


}
