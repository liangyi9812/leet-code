package com.edison.backpack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LiangYi
 * @date 2022/4/14
 * @note
 */
class BackPack01Test {

    @Test
    void maxValue() {
        int[] w = {2, 3, 4, 5, 9};
        int[] v = {3, 4, 5, 8, 10};
        System.out.println(BackPack01.maxValue(w, v, 20));
    }
}
