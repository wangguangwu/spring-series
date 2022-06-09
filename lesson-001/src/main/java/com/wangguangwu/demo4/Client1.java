package com.wangguangwu.demo4;

import com.wangguangwu.demo4.config.ThreadScope;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * 测试类
 *
 * @author wangguangwu
 */
@SuppressWarnings("all")
public class Client1 {

    public static void main(String[] args) throws InterruptedException {
        String beanXml = "classpath:/com/wangguangwu/demo4/bean3.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext() {
            @Override
            protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
                // 向容器中注册自定义的 scope
                beanFactory.registerScope(ThreadScope.THREAD_SCOPE, new ThreadScope());
                super.postProcessBeanFactory(beanFactory);
            }
        };
        // 设置配置文件
        context.setConfigLocation(beanXml);
        // 启动容器
        context.refresh();

        // 使用容器获取 bean
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread() + "," + context.getBean("threadBean"));
                System.out.println(Thread.currentThread() + "," + context.getBean("threadBean"));
            }).start();
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
