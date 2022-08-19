package com.edison.designpartten.abstractfactory.coursefactory;

import com.edison.designpartten.abstractfactory.product.INote;
import com.edison.designpartten.abstractfactory.product.IVideo;

/**
 * @author LiangYi
 * @date 2022-8-20
 */
public abstract class AbstractCourseFactory {

    public void init() {
        System.out.println("初始化");
    }

    protected abstract INote takeNote();

    protected abstract IVideo recordVideo();

}
