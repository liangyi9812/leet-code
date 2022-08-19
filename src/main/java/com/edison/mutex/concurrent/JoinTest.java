package com.edison.mutex.concurrent;

/**
 * @author LiangYi
 * @date 2022-8-3
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            System.out.println("业务逻辑1.....");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("业务逻辑2.....");
        });
        Thread thread3 = new Thread(() -> {
            System.out.println("业务逻辑3.....");
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        thread3.start();
        System.out.println("main done!");
    }

}
