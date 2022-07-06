package com.edison.leetcode;

import com.edison.base.TreeNode;
import com.edison.tree.TreeBase;

/**
 * @author LiangYi
 * @date 2022-6-19
 */
public class LeetCode104 {

    public static void main(String[] args) {
        TreeNode bfsBaseRoot = TreeBase.getBfsBaseRoot();
        System.out.println(maxDepth(bfsBaseRoot));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int deepLeft = maxDepth(root.left);
            int deepRight = maxDepth(root.right);
            return Math.max(deepLeft, deepRight) + 1;
        }

    }


}
