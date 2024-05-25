package com.edison.jdkcollection.queue.blocking;

import java.util.Arrays;

/**
 * @author liangyi
 * @date 2024/3/4
 */
public class BlockingQueue {
    // 放置元素索引
    private int inputIndex;
    // 取出元素索引
    private int takeIndex;
    // 元素数组
    private final String[] elements;
    // 数组中元素数量
    private int count;


    public BlockingQueue(int capacity) {
        elements = new String[capacity];
    }


    public Object take() throws InterruptedException {
        synchronized (this) {
            // 这里使用while的原因是线程被唤醒之后需要再判断一次数组是否已经有元素
            while (count == 0) {
                // 数组没有元素了，等待
                this.wait();
            }
            Object e = dequeue();
            this.notify();
            System.out.println("take method: " + Arrays.toString(elements));
            return e;
        }
    }


    public void put(String str) throws InterruptedException {
        synchronized (this) {
            // 这里使用while的原因是线程被唤醒之后需要再判断一次数组元素是否有空闲位置
            while (count == elements.length) {
                // 数组元素满了，等待
                this.wait();
            }
            enqueue(str);
            System.out.println("put method: " + Arrays.toString(elements));
            this.notify();
        }
    }

    /**
     * 入队方法
     *
     * @param e 元素
     */
    private void enqueue(String e) {
        elements[inputIndex] = e;

        // 如果数组已满，input返回开头
        if (++inputIndex == elements.length) {
            inputIndex = 0;
        }

        count++;
    }

    /**
     * 出队方法
     *
     * @return
     */
    private Object dequeue() {

        Object e = elements[takeIndex];
        elements[takeIndex] = null;
        // 如果takeIndex已到数组终点，返回开头
        if (++takeIndex == elements.length) {
            takeIndex = 0;
        }
        count--;
        return e;
    }
}
