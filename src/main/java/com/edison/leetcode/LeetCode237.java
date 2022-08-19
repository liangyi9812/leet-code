package com.edison.leetcode;

import com.edison.base.ListNode;

/**
 * @author LiangYi
 * @date 2022-7-11
 */
public class LeetCode237 {

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
