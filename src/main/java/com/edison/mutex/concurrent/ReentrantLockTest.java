package com.edison.mutex.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiangYi
 * @date 2022-8-2
 */
public class ReentrantLockTest {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();

        Thread lockTest1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 尝试获取锁");
            reentrantLock.lock();
            System.out.println(Thread.currentThread().getName() + " 获取到了锁");
            try {
                // 模拟业务逻辑 占用锁
                System.out.println(Thread.currentThread().getName() + " 业务逻辑1....");
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + " 业务逻辑1.... done !");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                reentrantLock.unlock();
            }
        }, "lockTest1");
        lockTest1.start();

        TimeUnit.SECONDS.sleep(2);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 尝试抢占锁");
            reentrantLock.lock();
            System.out.println(Thread.currentThread().getName() + " 抢占到了锁");
            try {
                // 模拟业务逻辑 抢占锁
                System.out.println(Thread.currentThread().getName() + " 业务逻辑2....");
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + " 业务逻辑2.... done !");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                reentrantLock.unlock();
            }
        }, "lockTest2").start();

        TimeUnit.SECONDS.sleep(2);

        Thread lockTest3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 尝试抢占锁");
            reentrantLock.lock();
            System.out.println(Thread.currentThread().getName() + " 抢占到了锁");
            try {
                // 模拟业务逻辑 抢占锁
                System.out.println(Thread.currentThread().getName() + " 业务逻辑3....");
                System.out.println(Thread.currentThread().getName() + " 业务逻辑3.... done !");
            } finally {
                reentrantLock.unlock();
            }
        }, "lockTest3");
        lockTest3.start();

        TimeUnit.SECONDS.sleep(2);

        lockTest3.interrupt();
        System.out.println("中断 lockTest3 线程！");
        System.err.println("=====================done=====================");

    }

}
