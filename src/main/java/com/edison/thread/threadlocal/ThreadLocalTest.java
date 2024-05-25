package com.edison.thread.threadlocal;

import com.edison.tools.Tool;

/**
 * @author LiangYi
 * @date 2022-6-22
 */
public class ThreadLocalTest {

    private static final ThreadLocal<String> threadLocal1 = ThreadLocal.withInitial(() -> "i'm threadLocal1");
    private static final ThreadLocal<String> threadLocal2 = ThreadLocal.withInitial(() -> "i'm threadLocal2");

    public static void main(String[] args) {
        Tool.print("value: " + threadLocal1.get());
        Tool.print("value: " + threadLocal2.get());
        Tool.print("value: " + threadLocal1.get());
        Tool.print("value: " + threadLocal2.get());
    }

}
