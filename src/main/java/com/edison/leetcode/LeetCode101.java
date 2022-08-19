package com.edison.leetcode;

import com.edison.base.TreeNode;

/**
 * @author LiangYi
 * @date 2022-7-12
 */
public class LeetCode101 {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if ((left == null || right == null) || left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}
