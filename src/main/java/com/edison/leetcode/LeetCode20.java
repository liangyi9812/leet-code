package com.edison.leetcode;

import java.util.Stack;

/**
 * @author LiangYi
 * @date 2022/3/22
 * @note
 */
public class LeetCode20 {

    public static void main(String[] args) {
        System.out.println(isValid("(){[{}]}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != ch) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }

}
