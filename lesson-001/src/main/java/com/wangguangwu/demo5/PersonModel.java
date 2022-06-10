package com.wangguangwu.demo5;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 注入容器中的 bean 有两种方法：
 * 1. ref 属性方式
 * 2. 内置 bean 的方式
 *
 * @author wangguangwu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonModel {

    private UserModel userModel;
    private CarModel carModel;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
