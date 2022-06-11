package com.wangguangwu.demo6;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

/**
 * 根据名称进行注入（byName）
 *
 * @author wangguangwu
 */
@Getter
@Setter
public class DiAutowire {

    @Getter
    @Setter
    public static class Service1 {
        private String desc;

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }
    }

    @Getter
    @Setter
    public static class Service2 {
        private String desc;


        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }
    }

    private Service1 service1;
    private Service2 service2;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
