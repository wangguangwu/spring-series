package com.wangguangwu.demo4;

/**
 * @author wangguangwu
 */
public class ThreadBeanScopeModel {

    public ThreadBeanScopeModel(String beanScope) {
        System.out.printf("线程:%s,create BeanScopeModel, {scope=%s},{this=%s}%n", Thread.currentThread(), beanScope, this);
    }



}
