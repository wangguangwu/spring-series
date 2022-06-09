package com.wangguangwu.demo3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过静态工厂创建 bean
 *
 * @author wangguangwu
 */
public class Client2 {

    public static void main(String[] args) {
        String beanXml = "classpath:/com/wangguangwu/demo3/bean2.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        System.out.println("spring 容器中的 bean 如下：");
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName + ":" + context.getBean(beanName));
        }
    }

}
