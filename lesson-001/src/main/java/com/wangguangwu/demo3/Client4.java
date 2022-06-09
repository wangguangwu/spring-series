package com.wangguangwu.demo3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过 FactoryBean 创建实例
 *
 * @author wangguangwu
 */
public class Client4 {

    public static void main(String[] args) {
        // 1. bean.xml
        String beanXml = "classpath:/com/wangguangwu/demo3/bean4.xml";

        // 2. 创建 ClassPathXmlApplicationContext 容器，给容器指定需要加载的 bean 配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        // 3. 获取容器中所有 bean 的名称
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName + ":" + context.getBean(beanName));
        }

        // 4. 多次获取 createByFactoryBean 看看是否是同一个对象
        // FactoryBean 中的 singleton 默认实现是单例
        System.out.println("createByFactoryBean:" + context.getBean("createByFactoryBean"));
        System.out.println("createByFactoryBean:" + context.getBean("createByFactoryBean"));

    }

}
