package com.edison.tree;

import com.edison.base.Stack;
import com.edison.base.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liangyi
 * @date 2024/3/11
 */
@Slf4j
class TreeTraversalTest {

    private static TreeNode head = TreeBase.getBaseRoot();
    private static ArrayList<Integer> res = new ArrayList<>();

    void preorder(TreeNode head) {
        if (head == null) {
            return;
        }
        res.add(head.val);
        preorder(head.left);
        preorder(head.right);
    }

    @Test
    void preorderTest() {
        preorder(head);
        log.info(String.valueOf(res));
    }

    void inorder(TreeNode head) {
        if (head == null) {
            return;
        }
        inorder(head.left);
        res.add(head.val);
        inorder(head.right);
    }

    @Test
    void inorderTest() {
        inorder(head);
        log.info(String.valueOf(res));
    }

    void postorder(TreeNode head) {
        if (head == null) {
            return;
        }
        postorder(head.left);
        postorder(head.right);
        res.add(head.val);
    }

    @Test
    void postorderTest() {
        postorder(head);
        log.info(String.valueOf(res));
    }

    @Test
    void preorderTraversal() {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) stack.push(node.right); // right
                if (node.left != null) stack.push(node.left); // left
                stack.push(node); // root
                stack.push(null);
            } else {
                res.add(stack.pop().val);
            }
        }
        log.info(res.toString());

    }

    @Test
    void inorderTraversal() {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) stack.push(node.right); // right
                stack.push(node);
                stack.push(null); // root
                if (node.left != null) stack.push(node.left); // left
            } else {
                res.add(stack.pop().val);
            }
        }
        log.info(res.toString());
    }

    @Test
    void postorderTraversal() {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                stack.push(node);
                stack.push(null); // root
                if (node.right != null) stack.push(node.right); // right
                if (node.left != null) stack.push(node.left); // left
            } else {
                res.add(stack.pop().val);
            }
        }
        log.info(res.toString());
    }

    @Test
    void BFS() {
        if (head == null) {
            return;
        }
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);

        while (!queue.isEmpty()) {
            List<Integer> tempRes = new ArrayList<>();
            int len = queue.size();

            while (len > 0) {
                TreeNode node = queue.poll();
                tempRes.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                len--;
            }
            res.add(tempRes);
        }
        log.info(res.toString());
    }

    @Test
    void DFS() {
        List<List<Integer>> res = new ArrayList<>();
        dfs(head, 0, res);
        log.info(res.toString());
    }

    void dfs(TreeNode head, int deep, List<List<Integer>> res) {
        if (head == null) return;
        deep++;

        if (res.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<>();
            res.add(item);
        }
        res.get(deep - 1).add(head.val);

        dfs(head.left, deep, res);
        dfs(head.right, deep, res);
    }

}
