package com.wangguangwu.demo3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过反射创建 bean
 *
 * @author wangguangwu
 */
public class Client1 {

    public static void main(String[] args) {
        // 1. 获取 bean1.xml 配置文件
        String beanXml = "classpath:/com/wangguangwu/demo3/bean1.xml";

        // 2. 创建 classPathXmlApplicationContext 容器，加载指定的配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        // 3. 获取容器中所有 bean 的名称
        System.out.println("spring容器中所有bean如下：");
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName + ":" + context.getBean(beanName));
        }

    }

}
