package com.wangguangwu.demo2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * 测试类
 *
 * @author wangguangwu
 */
public class Client1 {

    public static void main(String[] args) {
        // 1. bean 配置文件位置
        String beanXml = "classpath:/com/wangguangwu/demo2/bean1.xml";

        // 2. 创建 ClassPathXmlApplicationContext 容器，给容器指定需要加载的 bean 配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        // 3. 获取 bean 的别名
        List<String> list = Arrays.asList("user1", "user2", "user3", "user4", "user5");

        System.out.println(list + " 的别名如下：");
        // getAliases: 通过 bean 名称获取这个 bean 的所有别名
        list.forEach(beanName -> {
            // 获取 bean 的别名
            String[] aliases = context.getAliases(beanName);
            System.out.printf("beanName:%s,别名:[%s]%n", beanName, String.join(",", aliases));
        });

        System.out.println();
        System.out.println("spring容器中所有bean如下：");

        // getBeanDefinitionNames：返回 spring 容器中定义的所有 bean 的名称
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            // 获取 bean 的别名
            String[] aliases = context.getAliases(beanName);
            System.out.printf("beanName:%s,别名:[%s]%n", beanName, String.join(",", aliases));
        }

    }

}
