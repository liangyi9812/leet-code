package com.edison.designpartten.factorymethod.java;

import com.edison.designpartten.factorymethod.Course;
import com.edison.designpartten.factorymethod.CourseFactory;

/**
 * @author LiangYi
 * @date 2022-8-20
 */
public class JavaCourseFactory implements CourseFactory {

    @Override
    public Course create() {
        return new Java();
    }

}
