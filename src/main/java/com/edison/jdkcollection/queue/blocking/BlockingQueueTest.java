package com.edison.jdkcollection.queue.blocking;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author liangyi
 * @date 2024/3/1
 */
public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        arrayBlockingQueue.put("1");
        arrayBlockingQueue.put("2");
        arrayBlockingQueue.put("3");
        arrayBlockingQueue.put("4");
        arrayBlockingQueue.put("5");
        arrayBlockingQueue.put("6");
        arrayBlockingQueue.put("7");
        arrayBlockingQueue.put("8");
        arrayBlockingQueue.put("9");
        arrayBlockingQueue.put("10");
        // 超出容量会阻塞
        arrayBlockingQueue.put("11");

    }

}
