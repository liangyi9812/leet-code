package com.edison.mutex.counter;

/**
 * @author LiangYi
 * @date 2022-8-3
 */
public class SynchronizedCounter implements Counter{

    private int i;
    private final Object lock = new Object();

    @Override
    public void increment() {
        synchronized (lock) {
            this.i++;
        }
    }

    @Override
    public int addAndGet(int step) {
        synchronized (lock) {
            this.i += step;
            return getCount();
        }
    }

    @Override
    public int getCount() {
        return i;
    }
}
