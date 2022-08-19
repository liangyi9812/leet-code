package com.edison.designpartten.abstractfactory.python;

import com.edison.designpartten.abstractfactory.product.INote;

/**
 * @author LiangYi
 * @date 2022-8-20
 */
public class PythonNote implements INote {
    @Override
    public void edit() {
        System.out.println("edit Python note!");
    }
}
