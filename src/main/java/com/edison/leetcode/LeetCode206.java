package com.edison.leetcode;

import com.edison.base.ListNode;

/**
 * @author LiangYi
 * @data 2022/3/22
 * @note
 */
public class LeetCode206 {

    /**
     * 1 -> 2 -> 3 -> 4 -> 5
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode head = new ListNode(1, listNode2);
        System.out.println(head.print());
        System.out.println(reverseList(head).print());
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
