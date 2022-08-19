package com.edison.designpartten.producerconsumer.lockcase;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiangYi
 * @date 2022-7-29
 */

public class Shop {

    private static int breadCount = 10;
    private static final ReentrantLock lock = new ReentrantLock(true);
    private static final Condition c0 = lock.newCondition();

    public static void produce() {
        breadCount++;
        System.out.printf("Thread %s create one bread, bread count:%s %n", Thread.currentThread().getName(), breadCount);
    }

    public static void consume() {
        breadCount--;
        System.out.printf("Thread %s eat one bread, bread count:%s %n", Thread.currentThread().getName(), breadCount);
    }

    public static class Producer extends Thread {
        public Producer(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                System.out.println(getName() + " 获取了 lock");
                try {
                    while (breadCount >= 5) {
                        System.out.println(getName() + " 已生产到最大数值，开始await()");
                        c0.await();
                        System.out.println(getName() + " 被唤醒");
                    }
                    produce();
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(getName() + " begin signalAll()");
                    c0.signalAll();
                    System.out.println(getName() + " finish signalAll()");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                    System.out.println(getName() + " 释放了 lock");
                }
            }
        }
    }

    public static class Consumer extends Thread {
        public Consumer(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                System.out.println(getName() + " 获取了 lock");
                try {
                    while (breadCount == 0) {
                        System.out.println(getName() + " 已吃完bread，开始await()");
                        c0.await();
                        System.out.println(getName() + " 被唤醒");
                    }
                    consume();
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(getName() + " begin signalAll()");
                    c0.signalAll();
                    System.out.println(getName() + " finish signalAll()");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                    System.out.println(getName() + " 释放了 lock");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Consumer consumer1 = new Consumer("consumer1");
        Consumer consumer2 = new Consumer("consumer2");
        Producer producer1 = new Producer("producer1");
        Producer producer2 = new Producer("producer2");
        producer1.start();
        producer2.start();
        TimeUnit.SECONDS.sleep(2);
        consumer1.start();
        consumer2.start();
    }

}
