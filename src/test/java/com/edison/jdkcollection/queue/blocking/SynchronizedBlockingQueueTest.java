package com.edison.jdkcollection.queue.blocking;

import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author liangyi
 * @date 2024/3/4
 */
class BlockingQueueTest {

    @Test
    void test() {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
        final String item = "item";
        try {
            for (int i = 0; i < 2147483647; i++) {
                blockingQueue.put(item);
                if (blockingQueue.size() % 10000 == 0) {
                    System.out.println(blockingQueue.size());
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(blockingQueue.remainingCapacity());
    }
}
