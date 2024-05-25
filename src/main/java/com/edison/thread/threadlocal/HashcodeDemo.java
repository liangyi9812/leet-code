package com.edison.thread.threadlocal;

import com.edison.tools.Tool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liangyi
 * @date 2024/3/3
 */
public class HashcodeDemo {

    private static final AtomicInteger nextHashCode = new AtomicInteger();

    // 1640531527
    private static final int HASH_INCREMENT = 0x61c88647;

    public static void main(String[] args) {
        final int length = 16;
        for (int i = 0; i < length; i++) {
            int hashCode = nextHashCode.getAndAdd(HASH_INCREMENT);
            Tool.print("hashCode: " + hashCode + ", index: " + (hashCode & (length - 1)));
        }
    }

}
