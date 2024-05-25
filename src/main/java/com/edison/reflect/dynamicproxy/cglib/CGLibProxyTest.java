package com.edison.reflect.cglib;

/**
 * @author LiangYi
 * @date 2022-6-16
 */
public class CGLibProxyTest {
    public static void main(String[] args) {
        UserServiceImpl2 userServiceImpl2 = new UserServiceImpl2();
        UserCGLibProxy<UserServiceImpl2> cgLibProxy = new UserCGLibProxy<>(userServiceImpl2);
        UserServiceImpl2 proxyBean = cgLibProxy.getProxyBean();
        proxyBean.addUser();
    }

}
