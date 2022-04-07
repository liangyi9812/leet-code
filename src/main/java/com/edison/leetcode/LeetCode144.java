package com.edison.leetcode;

import com.edison.base.TreeNode;

import java.util.*;

/**
 * @author LiangYi
 * @data 2022/3/23
 * @note
 */
public class LeetCode144 {

    public static void main(String[] args) {
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode root = new TreeNode(1);
        root.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode7;
        treeNode3.right = treeNode8;
        preorderTraversal(root).forEach(System.out::println);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.pollLast();
            res.add(poll.val);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return res;
    }

}
