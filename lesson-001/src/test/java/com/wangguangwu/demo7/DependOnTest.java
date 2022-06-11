package com.wangguangwu.demo7;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author wangguangwu
 */
public class DependOnTest {

    @Test
    public void normalBeanTest() {
        // bean 对象的创建顺序和 bean.xml 中定义的顺序一致
        // bean 对象的销毁顺序和 bean.xml 中定义的顺序相反
        test("classpath:/com/wangguangwu/demo7/normalBean.xml");
    }

    @Test
    public void strongDependenceBeanTest() {
        // bean 对象的创建顺序和 bean 依赖的顺序一致
        // bean 销毁的顺序和 bean 依赖的顺序相反
        test("classpath:/com/wangguangwu/demo7/strongDependenceBean.xml");
    }

    @Test
    public void dependOnBeanTest() {
        // 通过 depend-on 属性去干预 bean 创建和销毁顺序
        test("classpath:/com/wangguangwu/demo7/dependOnBean.xml");
    }

    //=====================================私有构造方法=============================================

    public void test(String beanXml, String... beanNames) {
        System.out.println("spring 容器开始启动");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        System.out.println("spring 容器启动完毕");
        beanNames = beanNames.length == 0 ? context.getBeanDefinitionNames() : beanNames;
        for (String beanName : beanNames) {
            System.out.println(beanName + ":" + context.getBean(beanName));
        }
        System.out.println("准备关闭 spring 容器");
        // 关闭容器
        context.close();
        System.out.println("spring 容器已关闭");
    }

}
