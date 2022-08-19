package com.edison.jdkcollection.treemap;

import lombok.Data;

/**
 * @author LiangYi
 * @date 2022-7-27
 */

@Data
public class User implements Comparable<User>{

    private String name;

    private Integer age;

    @Override
    public int compareTo(User user) {
        return user.getAge().compareTo(this.age);
    }
}
