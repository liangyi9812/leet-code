package com.edison.mutex.volatileword;

import com.edison.tools.Tool;
import lombok.SneakyThrows;

/**
 * @author liangyi
 * @date 2024/3/6
 */
public class VolatileIncrementDemo {

    private static volatile int i;

    @SneakyThrows
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                i++;
            }
        }, "increment-1");

        Thread thread2 = new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                i++;
            }
        }, "increment-2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        Tool.print("result: " + i);

    }

}
