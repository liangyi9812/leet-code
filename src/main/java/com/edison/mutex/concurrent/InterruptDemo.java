package com.edison.mutex.concurrent;

import com.edison.tools.Tool;

import java.util.concurrent.TimeUnit;

/**
 * @author liangyi
 * @date 2024/3/2
 */
public class InterruptDemo {
    public static void main(String[] args) {

        Thread.currentThread().interrupt();
        Tool.print("interrupted: " + Thread.interrupted());

        Tool.print("开始睡眠");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Tool.print("发生中断");
        }

        Tool.print("睡眠结束");
        Tool.print("isInterrupted: " + Thread.currentThread().isInterrupted());

    }
}
