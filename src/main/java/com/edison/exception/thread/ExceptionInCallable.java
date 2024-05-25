package com.edison.exception.thread;

import com.edison.tools.Tool;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author liangyi
 * @date 2024/3/7
 */
public class ExceptionInCallable {
    public static void main(String[] args) throws InterruptedException {
        Callable<String> callable = () -> {
            System.out.println("callable running~");
            Tool.causeCheckedException();
            return "hello world";
        };

        FutureTask<String> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();

        String result = null;
        try {
            result = futureTask.get();
        } catch (Exception e) {
            Throwable cause = e.getCause();
            System.out.println(cause.getClass());
        }
        System.out.println(result);


    }
}
