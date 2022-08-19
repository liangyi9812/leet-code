package com.edison.designpartten.abstractfactory.python;

import com.edison.designpartten.abstractfactory.product.IVideo;

/**
 * @author LiangYi
 * @date 2022-8-20
 */
public class PythonVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("record Python video!");
    }
}
