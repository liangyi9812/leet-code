package com.edison.designpartten.factorymethod.python;

import com.edison.designpartten.factorymethod.Course;
import com.edison.designpartten.factorymethod.CourseFactory;

/**
 * @author LiangYi
 * @date 2022-8-20
 */
public class PythonFactory implements CourseFactory {
    @Override
    public Course create() {
        return new Python();
    }
}
