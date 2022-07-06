package com.edison.leetcode;

import com.edison.base.TreeNode;
import com.edison.tree.TreeBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author LiangYi
 * @date 2022-6-18
 */
public class LeetCode94 {

    public static void main(String[] args) {
        TreeNode baseRoot1 = TreeBase.getBaseRoot();
        TreeNode baseRoot2 = TreeBase.getBaseRoot();
        System.out.println(inorderTraversal(baseRoot1));
        System.out.println(inorder2(baseRoot1));

    }


    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private static void inorder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public static List<Integer> inorder2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode cur = root;
        while (!nodeStack.isEmpty() || cur != null) {
            if (cur != null) {
                nodeStack.push(cur);
                cur = cur.left;
            } else {
                TreeNode popNode = nodeStack.pop();
                res.add(popNode.val);
                cur = popNode.right;
            }
        }
        return res;
    }


}
