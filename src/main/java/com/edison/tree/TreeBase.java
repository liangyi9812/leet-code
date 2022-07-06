package com.edison.tree;

import com.edison.base.TreeNode;

/**
 * @author LiangYi
 * @date 2022-6-18
 */
public class TreeBase {

    /**
     *       1
     *     /  \
     *    3    2
     *   / \  / \
     *  5  7  6  8
     * @return rootTreeNode
     */
    public static TreeNode getBaseRoot() {
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode7;
        treeNode2.left = treeNode6;
        treeNode2.right = treeNode8;
        return treeNode1;
    }

    /**
     *       1
     *     /  \
     *    3    2
     *        / \
     *       6  8
     * @return rootTreeNode
     */
    public static TreeNode getBfsBaseRoot() {
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode2.left = treeNode6;
        treeNode2.right = treeNode8;
        return treeNode1;
    }

    public static TreeNode getBfsBaseRoot2() {
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode2.left = treeNode6;
        treeNode2.right = treeNode8;
        treeNode6.left = treeNode7;
        return treeNode1;
    }

}
