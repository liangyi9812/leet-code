package com.edison.jdkcollection.queue;

import java.util.PriorityQueue;

/**
 * @author LiangYi
 * @date 2022-6-17
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();


        priorityQueue.offer("1");
        priorityQueue.offer("2");
        priorityQueue.offer("5");
        priorityQueue.offer("3");
        priorityQueue.offer("4");

        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());

    }

}
