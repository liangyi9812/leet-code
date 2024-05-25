package com.edison.mutex;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liangyi
 * @date 2024/3/4
 */
public class SpinLock {
    private final AtomicReference<Thread> owner = new AtomicReference<>();

    public void lock() {
        // 如果锁未被占用，则设置当前线程为锁的拥有者
        while (!owner.compareAndSet(null, Thread.currentThread())) ;
    }

    public void unlock() {
        // 只有锁的拥有者才能释放锁
        owner.compareAndSet(Thread.currentThread(), null);
    }
}
