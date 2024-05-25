package com.edison.mutex.concurrent;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LiangYi
 * @date 2022-8-2
 */
public class AtomicIntegerTest {

    static class AtomicIntegerDemo {
        private final AtomicInteger atomicInteger = new AtomicInteger(0);

        public int increment() {
            return atomicInteger.incrementAndGet();
        }

        public int decrement() {
            return atomicInteger.decrementAndGet();
        }

        public int get() {
            return atomicInteger.get();
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        AtomicIntegerDemo demo = new AtomicIntegerDemo();
        Thread thread1 = new Thread(() -> {
            for (int j = 0; j < 1000; j++) {
                demo.increment();
            }
        }, "increment-1");
        thread1.start();

        Thread thread2 = new Thread(() -> {
            for (int j = 0; j < 1000; j++) {
                demo.increment();
            }
        }, "increment-2");
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("result: " + demo.get());
    }
}
