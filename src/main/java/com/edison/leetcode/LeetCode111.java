package com.edison.leetcode;

import com.edison.base.TreeNode;
import com.edison.tree.TreeBase;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author LiangYi
 * @date 2022-6-19
 */
public class LeetCode111 {

    public static void main(String[] args) {
        TreeNode bfsBaseRoot = TreeBase.getBfsBaseRoot();
        System.out.println(minDepth(bfsBaseRoot));
    }


    public static int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int minDepth = 0;
        while (!queue.isEmpty()) {
            minDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left == null && node.right == null) {
                    return minDepth;
                }
            }
        }
        return minDepth;
    }

}
