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
        Object result = method.invoke(target, args);
        System.out.println("after method " + method.getName() + "result:" + result);
        return null;
    }

    @SuppressWarnings("unchecked")
    public T getProxyBean() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


}
