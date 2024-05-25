package com.edison.exception.runnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author liangyi
 * @date 2024/3/7
 */
public class ExceptionInRunnable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = () -> {
            System.out.println("runnable~");
            throw new RuntimeException("exception in runnable");
        };

        FutureTask<Void> futureTask = new FutureTask<>(runnable, null);
        new Thread(futureTask).start();
        Void result = futureTask.get();
        System.out.println(result);
    }

}
