package com.edison.thread.threadlocal;

import com.edison.tools.Tool;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

/**
 * @author liangyi
 * @date 2024/3/3
 */
public class ThreadLocalLeakDemo {

    @SneakyThrows
    public static void main(String[] args) {
        setThreadLocal("Hello, ThreadLocal");
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        Thread thread = Thread.currentThread();
        Field field = thread.getClass().getDeclaredField("threadLocals");
        field.setAccessible(true);
        Object threadLocalMap = field.get(thread);
        Tool.print("threadLocalMap: " + threadLocalMap);

    }

    private static void setThreadLocal(String value) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set(value);
    }

}
