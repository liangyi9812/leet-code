package com.edison.mutex.counter;

/**
 * @author LiangYi
 * @date 2022-8-3
 */
public class CountTest {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new CustomCASCounter();
        Thread thread1 = new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                counter.increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                counter.increment();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(counter.getCount());

    }

}
