package com.edison.reflect.dynamicproxy.jdkproxy;

/**
 * @author LiangYi
 * @date 2022-6-16
 */
public class UserProxyTest {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserProxy<UserService> userServiceUserProxy = new UserProxy<>(userService);
        UserService proxyBean = userServiceUserProxy.getProxyBean();
        System.out.println("proxyBean: " + proxyBean);
        proxyBean.addUser();

    }

}
