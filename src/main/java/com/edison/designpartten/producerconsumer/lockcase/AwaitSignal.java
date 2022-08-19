package com.edison.designpartten.producerconsumer.lockcase;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiangYi
 * @date 2022-7-30
 */
public class AwaitSignal {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread waiter = new Thread(new waiter());
        waiter.start();
        Thread signaler = new Thread(new signaler());
        signaler.start();
    }

    static class waiter implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (!flag) {
                        System.out.println(Thread.currentThread().getName() + "当前条件不满足等待");
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + "接收到通知条件满足");
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class signaler implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    flag = false;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}
