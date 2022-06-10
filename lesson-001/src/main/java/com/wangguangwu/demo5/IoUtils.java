package com.wangguangwu.demo5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 根据配置文件 bean.xml，获取对应的 ClassPathXmlApplicationContext
 *
 * @author wangguangwu
 */
public final class IoUtils {

    public static ClassPathXmlApplicationContext context(String beanXml) {
        return new ClassPathXmlApplicationContext(beanXml);
    }

    private IoUtils() {
    }

}
