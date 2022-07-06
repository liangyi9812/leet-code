package com.edison.reflect.cglib;


/**
 * @author LiangYi
 * @date 2022-6-16
 */
public class UserServiceImpl2 {
    public void addUser() {
        System.out.println("添加用户");
    }

    public void updateUser(String str) {
        System.out.println("更新用户信息" + str);
    }
}
