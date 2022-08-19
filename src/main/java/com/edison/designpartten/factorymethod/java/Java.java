package com.edison.designpartten.factorymethod.java;

import com.edison.designpartten.factorymethod.Course;

/**
 * @author LiangYi
 * @date 2022-8-20
 */
public class Java implements Course {
    @Override
    public String getCourseName() {
        return "JAVA";
    }
}
