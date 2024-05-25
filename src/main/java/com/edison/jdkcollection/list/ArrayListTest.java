package com.edison.jdkcollection.list;

import java.util.ArrayList;

/**
 * @author liangyi
 * @date 2024/2/23
 */
public class ArrayListTest {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList(){{
            add(1);
            add(2);
            add(2);
            add(2);
        }};


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
        System.out.println(list);
    }
}
