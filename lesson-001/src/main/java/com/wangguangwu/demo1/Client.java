package com.wangguangwu.demo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 *
 * @author wangguangwu
 */
public class Client {

    public static void main(String[] args) {
        // 1. bean 配置文件位置
        // 在 resource 目录下创建文件夹，需要按顺序依次创建
        String beanXml = "classpath:/com/wangguangwu/demo1/bean.xml";

        // 2. 创建 ClassPathXmlApplicationContext 容器，给容器指定需要加载的 bean 配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        // 3. 从容器中获取需要的 bean
        HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);

        // 4. 使用对象
        helloWorld.say();
    }

}
