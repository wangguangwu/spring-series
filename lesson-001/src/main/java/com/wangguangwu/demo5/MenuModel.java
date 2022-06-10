package com.wangguangwu.demo5;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

/**
 * 菜单类
 *
 * @author wangguangwu
 */
@Getter
@Setter
public class MenuModel {

    private String label;
    private Integer theSort;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
