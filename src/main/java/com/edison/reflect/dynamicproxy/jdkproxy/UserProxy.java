package com.edison.reflect.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author LiangYi
 * @date 2022-6-16
 */
public class UserProxy<T> implements InvocationHandler {

    private final T target;

    public UserProxy(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method " + method.getName());
        // 使用proxy对象调用其他方法
        if (method.getName().equals("addUser")) {
            Method otherMethod = proxy.getClass().getMethod("updateUser", String.class);
            otherMethod.invoke(proxy, "John Doe");
        }
        Object result = method.invoke(target, args);
        System.out.println("after method " + method.getName() + " result: " + result);
        return result;
    }

    @SuppressWarnings("unchecked")
    public T getProxyBean() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


}
