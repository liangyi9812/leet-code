package com.edison.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author liangyi
 * @date 2024/2/29
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 5; i++) {
            threadPool.submit(new SimpleRunnable(i));
        }
        TimeUnit.SECONDS.sleep(1);
//        List<Runnable> runnables = threadPool.shutdownNow();
        System.out.println("began to shutdown");
    }

    static class SimpleRunnable implements Runnable {

        private final int order;

        SimpleRunnable(int order) {
            this.order = order;
        }

        @Override
        public void run() {
            System.out.println("task" + order + " running~");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException in task" + order);
                throw new RuntimeException(e);
            }
            System.out.println("in task" + order + " thread, interrupted: " + Thread.currentThread().isInterrupted());
            System.out.println("task" + order + " finished!");
        }
    }

}
