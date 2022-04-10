package com.edison.leftgod.minstack;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author LiangYi
 * @data 2022/4/8
 * @note
 */
class MiniStackTest {
    private static MiniStack<Integer> miniStack;

    @BeforeAll
    static void setUp() {
        System.out.println("begin init miniStack");
        miniStack = new MiniStack<>();
        miniStack.push(3);
        miniStack.push(3);
    }

    @Test
    void push() {
        miniStack.push(1);
    }

    @Test
    void pop() {
        miniStack.pop();
    }

    @Test
    void getMin() {
        System.out.println("miniStack.getMin() ==> " + miniStack.getMin());
        assertEquals(miniStack.getMin(), 3);
    }

    @Test
    void baseTest() {
        miniStack = new MiniStack<>();
        miniStack.push(3);
        miniStack.push(3);
    }
}