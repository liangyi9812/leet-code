package com.edison.jdkcollection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author LiangYi
 * @date 2022-6-17
 */
public class QueueTest {

    public static void main(String[] args) {

        Deque<String> collection = new ArrayDeque<>(2);


        // 左贵右贱 左头右尾
        // Queue 接口	抛出异常	    返回特殊值
        // 插入队尾	    add(E e)	offer(E e)
        // 删除队首	    remove()	poll()
        // 查询队首元素	element()	peek()

        collection.add("java");
        collection.add("python");
        collection.add("go");

        System.out.println(collection);

        // 插头 equivalent to addFirst
        collection.push("stack");

        System.out.println(collection);
    }

}
