package com.edison.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiangYi
 * @date 2022/4/15
 * @note
 */
public class LeetCode118 {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    // 首尾为1
                    temp.add(1);
                } else {
                    List<Integer> upLayer = res.get(i - 1);
                    temp.add(upLayer.get(j - 1) + upLayer.get(j));
                }
            }
            res.add(temp);
        }
        return res;
    }

    public static List<List<Integer>> generateV2(int numRows) {
        Integer[][] dp = new Integer[numRows][numRows + 1];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        return array2List(dp);
    }

    private static <T>List<List<T>> array2List(T[][] source) {
        int h = source.length;
        int k = source[0].length;
        List<List<T>> res = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            List<T> temp = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                T t = source[i][j];
                if (t == null) {
                    continue;
                }
                temp.add(t);
            }
            res.add(temp);
        }
        return res;
    }

}

