package com.edison.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiangYi
 * @data 2022/4/15
 * @note
 */
public class LeetCode119 {

    public static List<Integer> getRow(int rowIndex) {
        Integer[] temp = new Integer[rowIndex + 1];
        for (int i = 0; i < rowIndex + 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp[j] = 1;
                } else {
                    temp[j] = temp[j - 1] + temp[j];
                }
            }
        }
        return Arrays.asList(temp);
    }

}
