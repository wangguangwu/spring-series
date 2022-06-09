package com.wangguangwu.demo4.config;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 自定义本地线程级别的作用域
 * <p>
 * 不同的线程中对应的 bean 实例是不同的，同一个线程中同名的 bean 是同一个实例
 *
 * @author wangguangwu
 */
@SuppressWarnings("all")
public class ThreadScope implements Scope {

    public static final String THREAD_SCOPE = "thread";

    private final ThreadLocal<Map<String, Object>> beanMap = ThreadLocal.withInitial(HashMap::new);

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object bean = beanMap.get().get(name);
        if (Objects.isNull(bean)) {
            bean = objectFactory.getObject();
            beanMap.get().put(name, bean);
        }
        return bean;
    }

    @Override
    @Nullable
    public Object remove(String name) {
        return this.beanMap.get().remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        // bean 作用域范围结束时调用的方法，用于 bean 清理
        System.out.println(name);
    }

    @Override
    @Nullable
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    @Nullable
    public String getConversationId() {
        return Thread.currentThread().getName();
    }
}
