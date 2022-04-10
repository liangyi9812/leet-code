package com.edison.leftgod.stackandqueue.base;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

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
}