package com.edison.designpartten.singleton;

/**
 * @author LiangYi
 * @date 2022-8-20
 */
public class HungrySingleton implements SingletonMark{

    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }

}
