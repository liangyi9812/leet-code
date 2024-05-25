package com.edison.reflect;

import com.edison.base.ListNode;
import com.edison.reflect.entity.TargetObject;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author liangyi
 * @date 2024/2/20
 */
public class Reflect {

    @SneakyThrows
    public static void main(String[] args) {
        // 获取Class对象的四种方式
        // 1. 通过 Class.forName() 传入类的全路径
        Class<?> class1 = Class.forName("com.edison.base.ListNode");
        System.out.println("class1: " + class1 + ", class1.hashCode: " + class1.hashCode());

        // 2. 具体类 类名.class
        Class<ListNode> class2 = ListNode.class;
        System.out.println("class2: " + class2 + ", class2.hashCode: " + class2.hashCode());

        // 3. 通过对象实例instance.getClass()
        ListNode listNode = new ListNode();
        Class<? extends ListNode> class3 = listNode.getClass();
        System.out.println("class3: " + class3 + ", class3.hashCode: " + class3.hashCode());

        // 4.通过类加载器xxxClassLoader.loadClass()传入类路径
        // 通过类加载器获取 Class 对象不会进行初始化，意味着不进行包括初始化等一系列步骤，静态代码块和静态对象不会得到执行
        Class<?> class4 = ClassLoader.getSystemClassLoader().loadClass("com.edison.base.ListNode");
        System.out.println("class4: " + class4 + ", class4.hashCode: " + class4.hashCode());

        // 常用反射操作

        // 1. 使用反射操作这个类的方法以及参数
        // 1.1 获取Class对象 并创建实例
        Class<?> targetObjectClass = Class.forName("com.edison.reflect.entity.TargetObject");
        TargetObject targetObject = (TargetObject) targetObjectClass.getDeclaredConstructor().newInstance();
        // 1.2 获取 TargetObject 类中定义的所有方法 (declaredMethods() 获取该类(不包括父类)的所有方法，包括私有方法
        Method[] declaredMethods = targetObjectClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod: " + declaredMethod);
        }
        // 1.3 获取 TargetObject 公共方法
        Method[] methods = targetObjectClass.getMethods();
        for (Method method : methods) {
            System.out.println("method: " + method);
        }

        // 1.4 调用指定方法
        // method
        Method publicSonMethod = targetObjectClass.getMethod("publicSonMethod", String.class);
        publicSonMethod.invoke(targetObject, "you~");
        // super method
        Method publicFatherMethod = targetObjectClass.getMethod("publicFatherMethod", String.class);
        publicFatherMethod.invoke(targetObject, "you too!");

        // declaredMethod
        Method privateSonMethod = targetObjectClass.getDeclaredMethod("privateSonMethod");
        // 设置私有方法可以被访问
        privateSonMethod.setAccessible(true);
        privateSonMethod.invoke(targetObject);

        // 1.5 获取指定参数并对参数进行修改
        // 自己的参数
        Field sonPrivateValue = targetObjectClass.getDeclaredField("sonPrivateValue");
        sonPrivateValue.setAccessible(true);
        System.out.println("get Field: " + sonPrivateValue.get(targetObject));

        sonPrivateValue.set(targetObject, "new son");
        System.out.println("after set Field: " + sonPrivateValue.get(targetObject));

        targetObject.publicSonMethod("gaga");

    }

}
