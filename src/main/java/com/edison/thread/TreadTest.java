package com.edison.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author LiangYi
 * @date 2022-6-22
 */
public class TreadTest {

    public static void main(String[] args) {

        System.out.println("主线程开始。。。");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException("主线程InterruptedException");
        }
        Thread thread1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException("InterruptedException");
            }
        });
        thread1.start();

        thread1.interrupt();


    }

}
