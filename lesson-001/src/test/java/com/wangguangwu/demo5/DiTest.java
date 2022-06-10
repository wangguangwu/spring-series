package com.wangguangwu.demo5;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangguangwu
 */
public class DiTest {

    @Test
    public void testDiByConstructorParamIndex() {
        // 根据构造器参数索引注入
        // 对参数顺序有很强的依赖性
        // 不建议在代码中修改构造函数，如果需要新增参数，可以通过新增一个构造函数实现
        String beanXml = "classpath:/com/wangguangwu/demo5/diByConstructorParamIndex.xml";
        test(beanXml, "diByConstructorParamIndex");
    }

    @Test
    public void testDiByConstructorParamType() {
        // 根据构造器参数类型注入
        // 很难通过 bean 的配置文件，知道这个参数是对应 UserModel 中的哪个属性的，代码的可读性不好
        // 比如我想知道这每个参数对应 UserModel 中的哪个属性，必须要去看 UserModel 的源码
        String beanXml = "classpath:/com/wangguangwu/demo5/diByConstructorParamType.xml";
        test(beanXml, "diByConstructorParamType");
    }

    @Test
    public void testDiByConstructorParamName() {
        // 根据构造器参数名称注入
        // java 通过反射可以获取到方法的名称，不过源码中的参数通过编译之后会变成 class 对象
        // 通常情况下，源码变成字节码文件后，参数的真是名称会丢失，参数的名称会变成 arg0, arg1, arg2 之类，和实际名称不一致
        // 如果需要将源码中的参数名称保留在编译之后的 class 文件中，编译时需要使用命令
        // javac -parameters java源码
        String beanXml = "classpath:/com/wangguangwu/demo5/diByConstructorParamName.xml";
        test(beanXml, "diByConstructorParamName");
    }

    @Test
    public void testDiByConstructorParamName2() {
        // 根据构造器参数名称注入
        // 使用注解，避免出现编译之后参数名称变更的问题
        String beanXml = "classpath:/com/wangguangwu/demo5/diByConstructorParamName2.xml";
        test(beanXml, "diByConstructorParamName");
    }

    @Test
    public void test() {
        // 使用构造器注入需要指定对应构造函数中所有参数的值
        // setter 方法可以按需进行注入
        String beanXml = "classpath:/com/wangguangwu/demo5/diBySetter.xml";
        test(beanXml, "diBySetter");
    }

    @Test
    public void diBean() {
        String beanXml = "classpath:/com/wangguangwu/demo5/diBean.xml";
        test(beanXml, "diBeanByConstructor", "diBeanBySetter");
    }

    @Test
    public void diOtherType() {
        String beanXml = "classpath:/com/wangguangwu/demo5/diOtherType.xml";
        test(beanXml, "diOtherType");
    }


    //=============================私有方法=====================================

    private void test(String beanXml, String... beanName) {
        ClassPathXmlApplicationContext context = IoUtils.context(beanXml);
        Assertions.assertNotNull(context, "获取 spring 容器失败");
        for (String s : beanName) {
            System.out.println(context.getBean(s));
        }
    }

}
