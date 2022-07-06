package com.edison.leetcode;

import com.edison.base.TreeNode;
import com.edison.tree.TreeBase;

import java.util.ArrayDeque;

/**
 * @author LiangYi
 * @date 2022-6-19
 */
public class LeetCode110 {

    public static void main(String[] args) {
        TreeNode bfsBaseRoot = TreeBase.getBfsBaseRoot();
        System.out.println(isBalanced(bfsBaseRoot));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int maxDepth = maxDepth(root);
        int minDepth = minDepth(root);
        return maxDepth - minDepth <= 1;
    }

    private static int minDepth(TreeNode root) {
        if (root.left == null || root.right == null) {
            return 0;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        int minDepth = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            minDepth++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return minDepth;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return minDepth;
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int i1 = maxDepth(root.left);
        int i2 = maxDepth(root.right);
        return Math.max(i1, i2) + 1;
    }

}
