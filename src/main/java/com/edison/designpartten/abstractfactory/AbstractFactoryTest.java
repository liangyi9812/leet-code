package com.edison.designpartten.abstractfactory;

import com.edison.designpartten.abstractfactory.java.JavaCourseFactory;

/**
 * 抽象工厂 <br/>
 *
 * Java 和 Python 两个产品族，Video 和 Note 两个产品等级
 * @author LiangYi
 * @date 2022-8-20
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        JavaCourseFactory javaCourseFactory = new JavaCourseFactory();

        javaCourseFactory.takeNote().edit();
        javaCourseFactory.recordVideo().record();

    }

}
