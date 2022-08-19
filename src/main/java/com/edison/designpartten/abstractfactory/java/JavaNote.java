package com.edison.designpartten.abstractfactory.java;

import com.edison.designpartten.abstractfactory.product.INote;

/**
 * @author LiangYi
 * @date 2022-8-20
 */
public class JavaNote implements INote {
    @Override
    public void edit() {
        System.out.println("edit java note!");
    }
}
