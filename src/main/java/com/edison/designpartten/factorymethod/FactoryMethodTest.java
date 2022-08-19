package com.edison.designpartten.factorymethod;

import com.edison.designpartten.factorymethod.python.PythonFactory;

/**
 * 工厂方法
 *
 * @author LiangYi
 * @date 2022-8-20
 */
public class FactoryMethodTest {

    public static void main(String[] args) {

        PythonFactory pythonFactory = new PythonFactory();
        Course course = pythonFactory.create();
        System.out.println(course.getCourseName());

    }

}
