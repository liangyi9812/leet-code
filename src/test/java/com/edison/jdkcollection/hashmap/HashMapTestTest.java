package com.edison.jdkcollection.hashmap;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liangyi
 * @date 2024/2/25
 */
class HashMapTestTest {

    private final HashMap<String, String> map = new HashMap<>();

    @Test
    void testPut() {
        map.put("key1", "value1");
        map.put("key1", "value99");
        map.put("key2", "value3");
    }

}
