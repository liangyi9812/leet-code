package com.edison.leetcode;

import com.edison.base.ListNode;

import java.util.ArrayList;

/**
 * @author LiangYi
 * @date 2022-7-11
 */
public class LeetCode234 {

    public static boolean isPalindrome(ListNode head) {
        ArrayList<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        int index = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums.get(index++) != nums.get(i)) {
                return false;
            }
        }
        return true;
    }

}
