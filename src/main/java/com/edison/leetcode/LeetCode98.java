package com.edison.leetcode;

import com.edison.base.TreeNode;
import com.edison.tree.TreeBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiangYi
 * @date 2022-7-11
 */
public class LeetCode98 {

    public static void main(String[] args) {
        TreeNode root = TreeBase.getSearchRoot();
        System.out.println(isValidBST(root));

        Integer i1 = new Integer(1);
        changeInt(i1);
        System.out.println(i1);
    }

    public static void changeInt(Integer integer) {
        integer = new Integer(100);
    }

    public static boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) >= res.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidBST(TreeNode root, Integer preMin) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left, preMin)) {
            return false;
        }
        if (preMin > root.val) {
            return false;
        }
        preMin = root.val;
        return isValidBST(root.right, preMin);
    }

    public static void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }
}
