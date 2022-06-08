package com.wangguangwu.demo2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangguangwu
 */
public class Client3 {

    public static void main(String[] args) {
        // 1. 获取 bean.xml
        String beanXml = "classpath:/com/wangguangwu/demo2/bean3.xml";

        // 2. 获取 ClassPathXmlApplicationContext
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        // 3. 获取别名
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            String[] aliases = context.getAliases(beanName);
            System.out.printf("beanName:%s,别名:[%s]%n", beanName, String.join(",", aliases));
        }

    }

}
