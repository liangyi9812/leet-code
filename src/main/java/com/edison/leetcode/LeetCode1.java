package com.edison.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author LiangYi
 * @date 2022-7-9
 */
public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return IntStream.of(i, hashMap.get(target - nums[i])).toArray();
            }
            hashMap.put(nums[i], i);
        }
        return IntStream.of(-1, -1).toArray();
    }

}
