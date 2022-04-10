package com.edison.leftgod.stackandqueue.base;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author LiangYi
 * @data 2022/4/10
 * @note
 */
class StackProcessTest {

    @Test
    void sortStack() {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(10);
        integerStack.push(5);
        integerStack.push(7);
        integerStack.push(1);
        Stack<Integer> sort = StackProcess.sortStack(integerStack);
        System.out.println("done! " + sort);
    }

    @Test
    void findWindowMaxRes() {
        int[] intData = {4, 3, 5, 4, 3, 3, 6, 7};
        int windowSize = 3;
        List<Integer> maxRes = StackProcess.findWindowMaxRes(intData, 3);

        assertEquals(intData.length - windowSize + 1, maxRes.size());
        maxRes.forEach(System.out::println);
    }
}