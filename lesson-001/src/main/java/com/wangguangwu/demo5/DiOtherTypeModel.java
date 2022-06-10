package com.wangguangwu.demo5;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 注入其他类型的数据
 *
 * @author wangguangwu
 */
@Getter
@Setter
public class DiOtherTypeModel {

    /**
     * 注入 list
     */
    private List<String> list1;

    /**
     * 注入 set
     */
    private Set<UserModel> set1;

    /**
     * 注入 map
     */
    private Map<String, Integer> map1;

    /**
     * 注入数组
     */
    private int[] array1;

    /**
     * 注入 properties
     */
    private Properties properties1;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
