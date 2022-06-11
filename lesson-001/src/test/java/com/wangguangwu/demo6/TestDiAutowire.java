package com.wangguangwu.demo6;

import com.wangguangwu.demo5.IoUtils;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;
import java.util.List;

/**
 * @author wangguangwu
 */
public class TestDiAutowire {

    @Test
    public void testIsAssignableFrom() {
        // isAssignableFrom(Class<?> cls) 方法
        // 示例：c1.isAssignableFrom(c2)，判断 c2 和 c1 是否相等，或者 c2 是否是 c1 的子类
        Assertions.assertTrue(Object.class.isAssignableFrom(Integer.class), "错误");
        System.out.println(Object.class.isAssignableFrom(int.class));
        System.out.println(Object.class.isAssignableFrom(List.class));
        System.out.println(Collection.class.isAssignableFrom(List.class));
        System.out.println(List.class.isAssignableFrom(Collection.class));
    }

    @Test
    public void testDiAutowireByName() {
        String beanXml = "classpath:/com/wangguangwu/demo6/diAutowireByName.xml";
        test(beanXml, "diAutowireByName1", "diAutowireByName2");
    }

    @Test
    public void testDiAutowireByType() {
        String beanXml = "classpath:/com/wangguangwu/demo6/diAutowireByType.xml";
        test(beanXml, "diAutowireByType");
    }

    @Test
    public void testDiAutowireByTypeExtend() {
        String beanXml = "classpath:/com/wangguangwu/demo6/diAutowireByTypeExtend.xml";
        test(beanXml);
    }

    @Test
    public void testDiAutowireByConstructor() {
        String beanXml = "classpath:/com/wangguangwu/demo6/diAutowireByConstructor.xml";
        // 可以通过调整修改 bean.xml 中的 bean 来使 spring 调用不同的构造方法（贪婪方式的注入原则）
        test(beanXml, "diAutowireByConstructor");
    }

    @Test
    public void testAutowireByDefault() {
        String beanXml = "classpath:/com/wangguangwu/demo6/diAutowireByDefault.xml";
        test(beanXml, "diAutowireByDefault1", "diAutowireByDefault2");
    }


    //==========================私有方法=====================================
    private void test(String beanXml, String... beanName) {
        ClassPathXmlApplicationContext context = IoUtils.context(beanXml);
        Assertions.assertNotNull(context, "spring 容器为空");
        // 如果没有确定的 bean 名称，就拿出所有的 bean
        beanName = beanName.length == 0 ? context.getBeanDefinitionNames() : beanName;
        for (String name : beanName) {
            System.out.println(name + ":" + context.getBean(name));
        }
    }

}
