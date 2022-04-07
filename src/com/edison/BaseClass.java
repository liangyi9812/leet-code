package com.edison;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author LiangYi
 * @data 2022/3/24
 * @note
 */
public class BaseClass {

    public static void main(String[] args) {
        List<String> pros = List.of("c", "c++", "java", "python", "go", "rust");
        Deque<String> deque = new ArrayDeque<>(pros);
        System.out.println("1111");

    }
}
