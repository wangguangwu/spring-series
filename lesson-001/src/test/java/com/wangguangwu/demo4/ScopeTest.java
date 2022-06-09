package com.wangguangwu.demo4;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author wangguangwu
 */
public class ScopeTest {

    ClassPathXmlApplicationContext context;

    @Before
    public void init() {
        System.out.println("spring 容器准备启动...");
        // 1. 根据不同场景指定 bean.xml
        String beanXml = "classpath:/com/wangguangwu/demo4/bean2.xml";

        // 2. 创建 ClassPathXmlApplicationContext 容器，给容器指定需要加载的 bean 配置文件
        this.context = new ClassPathXmlApplicationContext(beanXml);
        System.out.println("spring 容器启动完毕!");
    }

    @Test
    public void singletonBean() {
        System.out.println("=====================单例 bean，每次获取的 bean 实例都一样=========================");
        // 从输出中可以看出，bean 的构造方法是在容器启动过程中调用的，说明这个 bean 实例在容器启动过程中就创建好了，放在容器中缓存
        // 返回的是同一个 bean 对象
        Assertions.assertNotNull(context, "spring 容器为空");
        System.out.println(context.getBean("singletonBean"));
        System.out.println(context.getBean("singletonBean"));
        System.out.println(context.getBean("singletonBean"));
    }

    @Test
    public void prototypeBean() {
        System.out.println("=====================多例 bean，每次获取的 bean 实例都不相同=========================");
        // 从输出中可以看出，容器启动过程中没有调用bean 的构造方法
        // 每次获取的都是不同的实例，在获取时才会调用构造方法创建 bean 实例
        Assertions.assertNotNull(context, "spring 容器为空");
        System.out.println(context.getBean("prototypeBean"));
        System.out.println(context.getBean("prototypeBean"));
        System.out.println(context.getBean("prototypeBean"));
    }

}
