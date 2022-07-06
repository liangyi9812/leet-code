package com.edison.leetcode;

import com.edison.base.TreeNode;
import com.edison.tree.TreeBase;

import java.util.*;

/**
 * @author LiangYi
 * @date 2022-6-18
 */
public class LeetCode102 {

    public static void main(String[] args) {
        TreeNode bfsBaseRoot1 = TreeBase.getBfsBaseRoot();
        TreeNode bfsBaseRoot2 = TreeBase.getBfsBaseRoot();
        System.out.println(levelOrder(bfsBaseRoot2));
        System.out.println(dfsOrder(bfsBaseRoot2));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        final TreeNode nil = new TreeNode();
        ArrayList<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tempRes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode == null) {
                    continue;
                }
                if (treeNode != nil) {
                    tempRes.add(treeNode.val);
                    queue.offer(treeNode.left != null ? treeNode.left : nil);
                    queue.offer(treeNode.right != null ? treeNode.right : nil);
                } else {
                    tempRes.add(null);
                }
            }
            res.add(tempRes);
        }
        return res;
    }

    public static List<List<Integer>> dfsOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, root, 1);
        return res;
    }

    private static void dfs(List<List<Integer>> res, TreeNode node, int deep) {
        if (node == null) {
            return;
        }

        if (res.size() < deep) {
            res.add(new ArrayList<>());
        }
        res.get(deep - 1).add(node.val);
        dfs(res, node.left, deep + 1);
        dfs(res, node.right, deep + 1);
    }
}
