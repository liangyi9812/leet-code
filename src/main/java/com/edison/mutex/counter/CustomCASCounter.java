package com.edison.mutex.counter;

import sun.misc.Unsafe;

/**
 * @author LiangYi
 * @date 2022-8-3
 */
public class CustomCASCounter implements Counter{

    private static final Unsafe UNSAFE;
    private static final long VALUE_OFFSET;

    private volatile int value;

    static {
        try {
            UNSAFE = Unsafe.getUnsafe();
            VALUE_OFFSET = UNSAFE.objectFieldOffset(CustomCASCounter.class.getDeclaredField("value"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }


    @Override
    public void increment() {
        UNSAFE.getAndAddInt(this, VALUE_OFFSET, 1);
    }

    @Override
    public int addAndGet(int step) {
        return UNSAFE.getAndAddInt(this, VALUE_OFFSET, step);
    }

    @Override
    public int getCount() {
        return value;
    }
}
