package com.edison.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liangyi
 * @date 2024/2/28
 */
public class VolatileAtomicityDemo {
    public volatile static int inc = 0;

    public synchronized void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        VolatileAtomicityDemo volatileAtomicityDemo = new VolatileAtomicityDemo();
        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j < 500; j++) {
                    volatileAtomicityDemo.increase();
                }
            });
        }
        // 等待1.5秒，保证上面程序执行完成
//        Thread.sleep(1500);
        threadPool.shutdown();
        while (!threadPool.isTerminated()) {
            System.out.println("waiting for thread pool to terminate");
            Thread.sleep(1000);
        }
        System.out.println(inc);
    }
}
