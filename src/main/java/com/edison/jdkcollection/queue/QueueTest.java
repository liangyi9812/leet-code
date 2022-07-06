package com.edison.jdkcollection.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * @author LiangYi
 * @date 2022-6-17
 */
public class QueueTest {

    public static void main(String[] args) {

        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        LinkedList<String> linkedList = new LinkedList<>();

        // 左贵右贱 左头右尾
        // Queue 接口	抛出异常	    返回特殊值
        // 插入队尾	    add(E e)	offer(E e)
        // 删除队首	    remove()	poll()
        // 查询队首元素	element()	peek()

        arrayDeque.add("java");
        arrayDeque.add("python");
        arrayDeque.add("go");

        arrayDeque.addLast("c++");

        arrayDeque.push("rust");
        arrayDeque.push(null);

        System.out.println(arrayDeque);
        //  [java, python, go, c++]

        System.out.println(arrayDeque.remove());
        //  java


    }

}
