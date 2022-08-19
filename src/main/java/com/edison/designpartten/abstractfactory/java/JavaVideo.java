package com.edison.designpartten.abstractfactory.java;

import com.edison.designpartten.abstractfactory.product.IVideo;

/**
 * @author LiangYi
 * @date 2022-8-20
 */
public class JavaVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("record java video!");
    }
}
