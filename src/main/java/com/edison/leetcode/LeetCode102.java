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
        TreeNode bfsBaseRoot2 = TreeBase.getBfsBaseRoot();
        System.out.println(levelOrder(bfsBaseRoot2));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tempRes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                tempRes.add(curNode.val);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
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
