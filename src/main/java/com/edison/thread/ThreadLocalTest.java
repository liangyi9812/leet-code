package com.edison.thread;

/**
 * @author LiangYi
 * @date 2022-6-22
 */
public class ThreadLocalTest {

    private static final ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "empty");

    public static void main(String[] args) {
        threadLocal.set(null);
    }

}
