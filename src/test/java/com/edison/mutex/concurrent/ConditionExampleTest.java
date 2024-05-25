package com.edison.mutex.concurrent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author liangyi
 * @date 2024/3/1
 */
class ConditionExampleTest {
    @Test
    public void testProducer() throws InterruptedException {
        ConditionExample example = new ConditionExample();
        ConditionExample.Producer producer = example.new Producer();
        producer.start();
        producer.join(); // 等待线程结束
        // 检查队列是否包含一个元素
        assertFalse(example.queue.isEmpty());
    }

    @Test
    public void testConsumer() throws InterruptedException {
        ConditionExample example = new ConditionExample();
        // 先向队列中添加一个元素
        example.queue.add("element");
        ConditionExample.Consumer consumer = example.new Consumer();
        consumer.start();
        consumer.join(); // 等待线程结束
        // 检查队列是否为空
        assertTrue(example.queue.isEmpty());
    }
}
