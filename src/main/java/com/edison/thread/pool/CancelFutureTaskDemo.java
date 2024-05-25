package com.edison.thread.pool;

import java.util.concurrent.*;

/**
 * @author liangyi
 * @date 2024/2/29
 */
public class CancelFutureTaskDemo {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        FutureTask<String> futureTask = new FutureTask<>(() -> {
            System.out.println("in task1 execute");
            for (int i = 0; i < 5; i++) {
                System.out.println("begin " + i + " task");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("in sleep interrupted: " + Thread.currentThread().isInterrupted());
                    throw new RuntimeException("custom interrupt");
                }
                System.out.println("interrupted: " + Thread.currentThread().isInterrupted());
            }
            System.out.println("task1 done");
            return "done";
        });

        threadPool.submit(futureTask);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("cancel futureTask: " + futureTask.cancel(true));

        try {
            futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

}
