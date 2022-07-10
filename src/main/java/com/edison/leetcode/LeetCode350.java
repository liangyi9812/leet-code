package com.edison.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiangYi
 * @date 2022-7-8
 */
public class LeetCode350 {

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 9};
        int[] nums2 = {4,4,8,9,9};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    /**
     * 输入：nums1 = [4,5,9], nums2 = [4,4,8,9,9]
     * 输出：[4,9]
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int l1 = 0;
        int l2 = 0;
        while (l1 < nums1.length && l2 < nums2.length) {
            if (nums1[l1] == nums2[l2]) {
                res.add(nums1[l1]);
                l1++;
                l2++;
            } else if (nums1[l1] > nums2[l2]) {
                l2++;
            } else {
                l1++;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
