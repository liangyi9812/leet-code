package com.edison.leetcode;

import java.util.ArrayDeque;

/**
 * @author LiangYi
 * @data 2022/3/22
 * @note
 */
public class LeetCode1047 {

    public static void main(String[] args) {
        String test = "abbaca";
        System.out.println(removeDuplicates(test));
    }

    public static String removeDuplicates(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (stack.peek() == ch) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(ch);
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.removeLast());
        }
        return res.toString();
    }

}
