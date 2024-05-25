package com.edison.exception.thread;

import com.edison.tools.Tool;

import java.util.concurrent.ExecutionException;

/**
 * @author liangyi
 * @date 2024/3/7
 */
public class ExceptionInRunnable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = () -> {
            System.out.println("runnable~");
            Tool.causeRuntimeException();
        };

        new Thread(runnable).start();
        System.out.println("main finished");
    }

}
