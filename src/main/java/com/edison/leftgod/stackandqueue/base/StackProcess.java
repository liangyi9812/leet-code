package com.edison.leftgod.stackandqueue.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author LiangYi
 * @date 2022/4/10
 * @note
 */
public class StackProcess {

    /**
     * 使用一个栈实现栈排序
     * @param stackToSort
     * @param <T>
     * @return Stack<T>
     */
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

    public static List<Integer> findWindowMaxRes(int[] arrays, int windowSize) {
        List<Integer> res = new ArrayList<>();
        if (windowSize == 0) {
            return res;
        }
        int startIndex = 0;
        for (int i = 0; i < arrays.length; i++) {
            int endIndex = startIndex + windowSize - 1;
            if (endIndex > arrays.length - 1) {
                // 窗口尾部超出数组大小
                break;
            }
            int max = Integer.MIN_VALUE;
            for (int j = startIndex; j <= endIndex; j++) {
                max = Math.max(max, arrays[j]);
            }
            startIndex++;
            res.add(max);
        }
        return res;
    }

}
