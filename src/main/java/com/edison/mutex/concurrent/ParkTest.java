package com.edison.mutex.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author LiangYi
 * @date 2022-8-3
 */
public class ParkTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 unpark");
            LockSupport.unpark(Thread.currentThread()); // t1先获取许可

            System.out.println("t1 park");
            LockSupport.park(); // 拥有许可，线程将不会被阻塞，然后会释放许可

            System.out.println("t1 再次 park 阻塞");
            LockSupport.park(Thread.currentThread()); // 线程将会被阻塞
        }, "t1");

        t1.start();

        TimeUnit.MILLISECONDS.sleep(500);
    }

}
