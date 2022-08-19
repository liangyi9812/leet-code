package com.edison.designpartten.singleton;

/**
 * @author LiangYi
 * @date 2022-8-20
 */
public class InnerSingleton implements SingletonMark{

    private InnerSingleton() {
    }

    public static InnerSingleton getInstance() {
        return inner.INSTANCE;
    }

    /**
     * 非静态内部类不能创建静态变量
     */
    private static class inner {
        private static final InnerSingleton INSTANCE = new InnerSingleton();
    }

}
