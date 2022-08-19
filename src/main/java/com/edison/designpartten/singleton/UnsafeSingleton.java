package com.edison.designpartten.singleton;

/**
 * @author LiangYi
 * @date 2022-8-20
 */
public class UnsafeSingleton implements SingletonMark{

    private static UnsafeSingleton instance;

    private UnsafeSingleton() {
    }

    public static UnsafeSingleton getInstance() {
        if (instance == null) {
            instance = new UnsafeSingleton();
        }
        return instance;
    }
}
