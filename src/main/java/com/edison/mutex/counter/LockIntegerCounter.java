package com.edison.mutex.counter;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiangYi
 * @date 2022-8-3
 */
public class LockIntegerCounter implements Counter{

    private int i = 0;
    private final ReentrantLock lock = new ReentrantLock();


    @Override
    public void increment() {
        lock.lock();
        try {
            i++;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int addAndGet(int step) {
        lock.lock();
        try {
            this.i += step;
        } finally {
            lock.unlock();
        }
        return getCount();
    }

    @Override
    public int getCount() {
        return i;
    }
}
