package com.edison.designpartten.singleton;

/**
 * @author liangyi
 * @date 2024/3/6
 */
public class SynchronizedSingleton implements SingletonMark {

    private static volatile SynchronizedSingleton INSTANCE;

    private SynchronizedSingleton() {}

    public static SynchronizedSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (SynchronizedSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SynchronizedSingleton();
                }
            }
        }
        return INSTANCE;
    }


}
