package com.edison.base;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiangYi
 * @data 2022/3/23
 * @note
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTree(Integer[] vals) {
        // todo 构建二叉树
        return null;
    }
}
