package com.edison.mutex.counter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LiangYi
 * @date 2022-8-3
 */
public class AtomicIntegerCounter implements Counter{

    private final AtomicInteger i = new AtomicInteger();

    @Override
    public void increment() {
        i.incrementAndGet();
    }

    @Override
    public int addAndGet(int step) {
        return i.addAndGet(step);
    }

    @Override
    public int getCount() {
        return i.get();
    }
}
