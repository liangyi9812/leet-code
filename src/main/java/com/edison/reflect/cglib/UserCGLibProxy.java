package com.edison.reflect.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author LiangYi
 * @date 2022-6-16
 */
public class UserCGLibProxy<T> implements MethodInterceptor {

    private T target;

    public UserCGLibProxy(T target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("cglib before method " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("cglib after method " + method.getName() + "result:" + result);
        return null;
    }

    public T getProxyBean() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setClassLoader(target.getClass().getClassLoader());
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }
}
