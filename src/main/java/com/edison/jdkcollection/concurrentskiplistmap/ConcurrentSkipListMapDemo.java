package com.edison.jdkcollection.concurrentskiplistmap;

import com.edison.base.CleanUser;
import com.edison.tools.Tool;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author liangyi
 * @date 2024/3/4
 */
public class ConcurrentSkipListMapDemo {
    public static void main(String[] args) {

        // key必须能排序,否则会抛出ClassCastException 类似TreeMap
        ConcurrentSkipListMap<CleanUser, String> concurrentSkipListMap = new ConcurrentSkipListMap<>();
        CleanUser user = new CleanUser();
        concurrentSkipListMap.put(user, "1");
        Tool.print(concurrentSkipListMap.get(user));

    }
}
