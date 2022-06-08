package com.wangguangwu.demo2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangguangwu
 */
public class Client2 {

    public static void main(String[] args) {
        // 1. 获取 bean.xml
        String beanXml = "classpath:/com/wangguangwu/demo2/bean2.xml";

        // 2. 创建 ClassPathXmlApplicationContext 容器，给容器指定需要加载的 bean 配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        // 3.获取别名
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            String[] aliases = context.getAliases(beanName);
            // 类名和别名都是自动生成的
            // 未指定 id 和 name 的 bean 对象，第一个 bean 会有别名
            // 别名为完整的类名，bean 名称为完整类名#编号
            System.out.printf("beanName:%s,别名:[%s]%n", beanName, String.join(",", aliases));
        }
    }

}
