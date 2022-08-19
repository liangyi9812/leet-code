package com.edison.jdkcollection.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiangYi
 * @date 2022-7-27
 */
public class HashMapThread extends Thread {

    private static final Map<Integer, Integer> map = new HashMap<>();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            map.put(i, i);
        }
        System.out.println(Thread.currentThread().getName() + " : " + map.size());
    }
}
