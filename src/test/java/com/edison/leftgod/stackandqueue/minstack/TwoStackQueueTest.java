package com.edison.leftgod.stackandqueue.minstack;

import com.edison.leftgod.stackandqueue.twostack.TwoStackQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LiangYi
 * @date 2022/4/10
 * @note
 */
class TwoStackQueueTest {

    @Test
    void add() {
        TwoStackQueue<Integer> queue = new TwoStackQueue<>();
        queue.add(1);
        queue.add(2);
        assertEquals(1, queue.peek());
    }

    @Test
    void poll() {
        TwoStackQueue<Integer> queue = new TwoStackQueue<>();
        queue.add(1);
        queue.add(2);
        assertEquals(1, queue.poll());
    }

}
