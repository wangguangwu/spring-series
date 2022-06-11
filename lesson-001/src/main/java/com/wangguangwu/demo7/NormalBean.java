package com.wangguangwu.demo7;

import org.springframework.beans.factory.DisposableBean;

/**
 * 无任何依赖的 bean 创建的顺序
 *
 * @author wangguangwu
 */
public class NormalBean {

    private static final String CONSTRUCTOR = " constructor!";

    private static final String DESTROY = " destroy()!";

    private NormalBean() {
    }

    /**
     * DisposableBean：spring 提供的一个接口
     * 接口内部提供了一个 destroy 方法，我们的 bean 类实现了这个接口后，当我们调用容器的 close 方法关闭容器的时候，spring 会调用容器中所有 bean 的 destroy 方法，用来做一些清理的工作
     */
    public static class Bean1 implements DisposableBean {

        public Bean1() {
            System.out.println(this.getClass() + CONSTRUCTOR);
        }

        @Override
        public void destroy()  {
            System.out.println(this.getClass() + DESTROY);
        }

    }

    public static class Bean2 implements DisposableBean {

        public Bean2() {
            System.out.println(this.getClass() + CONSTRUCTOR);
        }

        @Override
        public void destroy()  {
            System.out.println(this.getClass() + DESTROY);
        }

    }

    public static class Bean3 implements DisposableBean {

        public Bean3() {
            System.out.println(this.getClass() + CONSTRUCTOR);
        }

        @Override
        public void destroy()  {
            System.out.println(this.getClass() + DESTROY);
        }

    }

}
