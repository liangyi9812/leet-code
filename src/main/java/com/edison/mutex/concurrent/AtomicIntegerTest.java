package com.edison.mutex.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author LiangYi
 * @date 2022-8-2
 */
public class AtomicIntegerTest {

    public static void main(String[] args) {
        Integer i = 0;
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int j = 0; j < 100; j++) {
            new Thread(() -> {

                atomicInteger.addAndGet(1);
            }).start();
        }
        System.out.println(i);
        System.out.println(atomicInteger.get());

        LockSupport.unpark(Thread.currentThread());
    }
}
