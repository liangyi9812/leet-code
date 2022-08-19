package com.edison.leetcode;

import com.edison.base.ListNode;

/**
 * @author LiangYi
 * @date 2022-7-11
 */
public class LeetCode19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = head;
        int length = 0;
        while (dummyHead != null) {
            dummyHead = dummyHead.next;
            length++;
        }
        if (length == 1) {
            return null;
        }
        // when n == 1, delete cur.next
        ListNode cur = head;
        n = length - n;
        if (n == 0) {
            return head.next;
        }
        while (n != 1) {
            cur = cur.next;
            n--;
        }
        ListNode toDelete = cur.next;
        cur.next = toDelete.next;
        toDelete.next = null;
        return head;
    }

}
