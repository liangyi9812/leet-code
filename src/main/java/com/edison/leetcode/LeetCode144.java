package com.edison.leetcode;

import com.edison.base.TreeNode;
import com.edison.tree.TreeBase;

import java.util.*;

/**
 * @author LiangYi
 * @date 2022/3/23
 * @note
 */
public class LeetCode144 {

    public static void main(String[] args) {
        TreeNode baseRoot = TreeBase.getBaseRoot();
        preorderTraversal(baseRoot).forEach(System.out::print);
        System.out.println();
        System.out.println("==================");
        preorder2(baseRoot).forEach(System.out::print);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private static void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    public static List<Integer> preorder2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            res.add(node.val);
            if (node.right != null) {
                nodeStack.push(node.right);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
            }
        }
        return res;
    }

}
