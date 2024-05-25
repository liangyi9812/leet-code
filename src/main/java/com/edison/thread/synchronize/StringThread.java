package com.edison.thread.synchronize;

import lombok.SneakyThrows;

/**
 * @author liangyi
 * @date 2024/2/28
 */
public class StringThread implements Runnable {
    private static final String LOCK_PREFIX = "XXX---";

    private final String ip;

    public StringThread(String ip) {
        this.ip = ip;
    }

    private String getThreadName() {
        return Thread.currentThread().getName();
    }

    @SneakyThrows
    @Override
    public void run() {
        String lock = buildLock();
        synchronized (lock) {
            System.out.println("[" + getThreadName() + "]开始运行了");
            // 休眠5秒模拟脚本调用
            Thread.sleep(5000);
            System.out.println("[" + getThreadName() + "]结束运行了");
        }
    }

    private String buildLock() {
        StringBuilder sb = new StringBuilder();
        sb.append(LOCK_PREFIX);
        sb.append(ip);

        String lock = sb.toString().intern();
        System.out.println("[" + getThreadName() + "]构建了锁[" + lock + "]");

        return lock;
    }
}
