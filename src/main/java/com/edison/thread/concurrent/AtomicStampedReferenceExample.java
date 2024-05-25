package com.edison.thread.concurrent;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author liangyi
 * @date 2024/2/28
 */
public class AtomicStampedReferenceExample {
    public static void main(String[] args) {
        // 初始化一个引用对象和一个标记值
        Integer initialRef = 100;
        int initialStamp = 0;
        AtomicStampedReference<Integer> atomicStampedRef = new AtomicStampedReference<>(initialRef, initialStamp);

        // 执行一些并发操作
        Runnable task1 = () -> {
            int stamp = atomicStampedRef.getStamp(); // 获取当前标记值
            Integer value = atomicStampedRef.getReference(); // 获取当前引用对象
            System.out.println("Thread 1: Current value = " + value + ", Stamp = " + stamp);

            // 尝试更新引用对象和标记值

            System.out.println("Thread 1: Value updated successfully!, result: " + atomicStampedRef.compareAndSet(value, value + 10, stamp, stamp + 1));
        };

        Runnable task2 = () -> {
            int stamp = atomicStampedRef.getStamp(); // 获取当前标记值
            Integer value = atomicStampedRef.getReference(); // 获取当前引用对象
            System.out.println("Thread 2: Current value = " + value + ", Stamp = " + stamp);

            // 尝试更新引用对象和标记值，这里意图制造一个ABA的情况
            System.out.println("Thread 2: Value updated successfully! result: " + atomicStampedRef.compareAndSet(value, value + 10, stamp, stamp + 1));
        };

        // 创建并启动线程
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        thread1.start();
        thread2.start();

        // 等待线程执行完成
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 输出最终结果
        int finalStamp = atomicStampedRef.getStamp();
        Integer finalValue = atomicStampedRef.getReference();
        System.out.println("Final value = " + finalValue + ", Final Stamp = " + finalStamp);
    }
}
