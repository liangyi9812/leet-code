package com.edison.designpartten.abstractfactory.python;

import com.edison.designpartten.abstractfactory.coursefactory.AbstractCourseFactory;
import com.edison.designpartten.abstractfactory.product.INote;
import com.edison.designpartten.abstractfactory.product.IVideo;

/**
 * @author LiangYi
 * @date 2022-8-20
 */
public class PythonCourseFactory extends AbstractCourseFactory {
    @Override
    public INote takeNote() {
        return new PythonNote();
    }

    @Override
    public IVideo recordVideo() {
        return new PythonVideo();
    }
}
