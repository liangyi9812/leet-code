package com.edison.mutex.counter;

/**
 * @author LiangYi
 * @date 2022-8-3
 */
public interface Counter {

    void increment();

    int addAndGet(int step);

    int getCount();

}
