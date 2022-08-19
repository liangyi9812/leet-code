package com.edison.mutex.counter;

/**
 * @author LiangYi
 * @date 2022-8-3
 */
public class NotSafeCounter implements Counter{

    private volatile int i;

    @Override
    public void increment() {
        i++;
    }

    @Override
    public int addAndGet(int step) {
        return this.i + step;
    }

    @Override
    public int getCount() {
        return i;
    }
}
