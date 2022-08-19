package com.edison.leetcode;

import com.edison.base.TreeNode;

/**
 * @author LiangYi
 * @date 2022-7-12
 */
public class LeetCode108 {

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode node = sortedArrayToBST(nums);
        System.out.println(node);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return getNode(nums, 0, nums.length - 1);
    }

    private static TreeNode getNode(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (right + left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode l1 = getNode(nums, left, mid - 1);
        TreeNode r1 = getNode(nums, mid + 1, right);
        root.left = l1;
        root.right = r1;
        return root;
    }

}
