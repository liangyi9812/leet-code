package com.edison.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiangYi
 * @date 2022/4/18
 */
public class LeetCode228 {

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(format(nums[0]));
            return res;
        }
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1] + 1) {
                res.add(fast - 1 == slow ? format(nums[slow]) : format(nums[slow], nums[fast - 1]));
                slow = fast;
                if (slow == nums.length - 1) {
                    res.add(format(nums[slow]));
                }
            }
        }
        if (slow != nums.length - 1) {
            res.add(format(nums[slow], nums[nums.length - 1]));
        }
        return res;
    }

    private static String format(int... num) {
        if (num.length == 1) {
            return num[0] + "";
        } else {
            return num[0] + "->" + num[num.length - 1];
        }

    }

}
