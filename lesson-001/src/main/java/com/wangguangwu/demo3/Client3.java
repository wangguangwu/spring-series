package com.wangguangwu.demo3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过实例工厂创建 bean
 *
 * @author wangguangwu
 */
public class Client3 {

    public static void main(String[] args) {
        // 1. 获取 bean.xml
        String beanXml = "classpath:/com/wangguangwu/demo3/bean3.xml";
        // 2. 获取 ClassPathXmlApplicationContext
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        // 3. 获取 spring 容器中所有 bean 的名称
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            // 4. 根据名称拿到对应的 bean
            System.out.println(beanName + ":" + context.getBean(beanName));
        }
    }

}
