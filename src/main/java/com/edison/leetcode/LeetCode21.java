package com.edison.leetcode;

import com.edison.base.ListNode;

/**
 * @author LiangYi
 * @date 2022-7-11
 */
public class LeetCode21 {

    public static void main(String[] args) {
        ListNode listNode4 = new ListNode(4);
        ListNode listNode2 = new ListNode(2, listNode4);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode listNode44 = new ListNode(4);
        ListNode listNode33 = new ListNode(3, listNode44);
        ListNode listNode11 = new ListNode(1, listNode33);
        System.out.println("1: " + listNode1.print());
        System.out.println("2: " + listNode11.print());
        System.out.println(mergeTwoLists(listNode1, listNode11).print());
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(), cur = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            cur = cur.next;
        }
        while (list1 != null) {
            cur.next = new ListNode(list1.val);
            list1 = list1.next;
            cur = cur.next;
        }
        while (list2 != null) {
            cur.next = new ListNode(list2.val);
            list2 = list2.next;
            cur = cur.next;
        }
        return dummyHead.next;
    }

}
