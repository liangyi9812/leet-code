package com.edison.base;

/**
 * @author LiangYi
 * @date 2022-8-20
 */
public class AssertUtil {

    public static void assertEquals(Object cur, Object exp) {
        if (!cur.equals(exp)) {
            throw new IllegalArgumentException(String.format("Assert fail! (cur: %s | exp: %s)", cur, exp));
        }
        System.out.println("Assert success!");
    }

}
