package com.wangguangwu.demo3;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wangguangwu
 */
@Data
@AllArgsConstructor
public class UserModel {

    private String name;

    private int age;

    public UserModel() {
        this.name = "我是通过UserModel的无参构造方法创建的!";
    }

}
