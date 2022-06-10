package com.wangguangwu.demo5;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.ConstructorProperties;

/**
 * @author wangguangwu
 */
@Data
@NoArgsConstructor
public class CarModel {

    private String name;
    private String desc;

    /**
     * 通过使用注解，避免编译后参数名称变更的问题
     *
     * @param name name
     * @param desc desc
     */
    @ConstructorProperties({"name", "desc"})
    public CarModel(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
