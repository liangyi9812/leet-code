package com.edison.designpartten.singleton;

/**
 * @author LiangYi
 * @date 2022-8-20
 */
public class SynchronizedSingleton implements SingletonMark{

    private static volatile SynchronizedSingleton INSTANCE;

    private SynchronizedSingleton() {
    }

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
