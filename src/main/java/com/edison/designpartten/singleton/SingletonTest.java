package com.edison.designpartten.singleton;

import com.edison.base.AssertUtil;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author LiangYi
 * @date 2022-8-20
 */
public class SingletonTest {

    public static void main(String[] args) {
        final ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>(100);
        Object nil = new Object();

        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                SingletonMark instance = SynchronizedSingleton.getInstance();
                //SingletonMark instance = HungrySingleton.getInstance();
                //SingletonMark instance = EnumSingleton.getInstance();
                map.put(instance, nil);
            }).start();
        }

        AssertUtil.assertEquals(map.keySet().size(), 1);
    }

}
