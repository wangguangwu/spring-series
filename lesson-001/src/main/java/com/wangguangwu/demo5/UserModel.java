package com.wangguangwu.demo5;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author wangguangwu
 */
@Data
public class UserModel {

    private String name;
    private int age;
    private String desc;

    public UserModel() {
    }

    public UserModel(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public UserModel(String name, int age, String desc) {
        this.name = name;
        this.age = age;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
