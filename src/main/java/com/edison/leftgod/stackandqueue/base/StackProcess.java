package com.edison.leftgod.stackandqueue.base;

import java.util.Stack;

/**
 * @author LiangYi
 * @data 2022/4/10
 * @note
 */
public class StackProcess {

    public static <T extends Comparable<T>>Stack<T> sortStack(Stack<T> stackToSort) {
        Stack<T> stack = new Stack<>();
        if (stackToSort.isEmpty()) {
            return stack;
        }
        while (!stackToSort.isEmpty()) {
            T pop = stackToSort.pop();
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek().compareTo(pop) > 0) {
                    stackToSort.push(stack.pop());
                }
            }
            stack.push(pop);
        }
        return stack;
    }

}
