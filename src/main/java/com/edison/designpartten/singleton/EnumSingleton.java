package com.edison.designpartten.singleton;

/**
 * @author LiangYi
 * @date 2022-8-20
 */
public enum EnumSingleton implements SingletonMark{
    INSTANCE;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}