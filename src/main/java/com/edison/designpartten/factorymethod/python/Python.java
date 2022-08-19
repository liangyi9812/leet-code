package com.edison.designpartten.factorymethod.python;

import com.edison.designpartten.factorymethod.Course;

/**
 * @author LiangYi
 * @date 2022-8-20
 */
public class Python implements Course {
    @Override
    public String getCourseName() {
        return "PYTHON";
    }
}
