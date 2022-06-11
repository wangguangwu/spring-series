package com.wangguangwu.demo6;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * 满足条件的 bean 注入到集合中
 *
 * @author wangguangwu
 */
@Getter
@Setter
public class DiAutowireByTypeExtend {

    public interface IService1 {
    }

    @Getter
    @Setter
    public static class BaseService {

        private String desc;

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }
    }

    public static class Service1 extends BaseService implements IService1 {

    }

    public static class Service2 extends BaseService implements IService1 {
    }

    private List<IService1> serviceList;
    private List<BaseService> baseServiceList;
    private Map<String, IService1> service1Map;
    private Map<String, BaseService> baseServiceMap;


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
