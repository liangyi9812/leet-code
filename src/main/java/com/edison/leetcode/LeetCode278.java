package com.edison.leetcode;

/**
 * @author LiangYi
 * @date 2022/4/13
 * @note
 */
public class LeetCode278 {

    /**
     * {1,2,3,4,5,6,7,8}
     *
     * @param n
     * @return
     */
    public static int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean isBadVersion(int version) {
        return version > 5;
    }

}
