package com.wangguangwu.demo6;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 按照构造函数进行自动注入
 * <p>
 * Spring 会找到类中所有的构造方法（一个类中可能有多个构造方法）
 * 然后将这些构造方法进行排序
 * <p>
 * 先按照修饰符进行排序，public 方法放在前面，其他的排在后面
 * 如果修饰符相同，会按照构造函数参数数量倒叙，即采用贪婪的模式进行匹配，spring 容器会尽量多注入一些需要的对象
 * <p>
 * spring 会获取到一个构造函数列表，并对这个构造器列表进行轮询
 * 判断当前构造器所有参数是否在容器中都可以找到匹配的 bean 对象，
 * 如果可以找到就使用这个构造器进行注入，
 * 如果不能找到，就会跳过这个构造器，继续采用同样的方式匹配下一个构造器，直到找到一个合适的为止
 *
 * @author wangguangwu
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiAutowireByConstructor {

    @Getter
    @Setter
    public static class BaseService {

        private String desc;

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }

    }

    public static class Service1 extends BaseService {

    }

    public static class Service2 extends BaseService {

    }

    private Service1 service1;
    private Service2 service2;

    public DiAutowireByConstructor(Service1 service1) {
        this.service1 = service1;
    }

    public DiAutowireByConstructor(Service2 service2) {
        this.service2 = service2;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
