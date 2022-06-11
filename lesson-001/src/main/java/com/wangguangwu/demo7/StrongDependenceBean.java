package com.wangguangwu.demo7;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;

/**
 * 通过构造器强依赖 bean 创建和销毁顺序
 * <p>
 * 依赖关系：bean3->bean2->bean1
 *
 * @author wangguangwu
 */
public class StrongDependenceBean {

    private static final String CONSTRUCTOR = " constructor!";

    private static final String DESTROY = " destroy()!";

    private StrongDependenceBean() {
    }

    public static class Bean1 implements DisposableBean {

        public Bean1() {
            System.out.println(this.getClass() + CONSTRUCTOR);
        }

        @Override
        public void destroy() {
            System.out.println(this.getClass() + DESTROY);
        }
    }

    @Data
    public static class Bean2 implements DisposableBean {

        private Bean1 bean1;

        /**
         * 创建 bean2 的时候需要传入一个 bean1 对象，对 bean1 产生了强依赖
         *
         * @param bean1 bean1
         */
        public Bean2(Bean1 bean1) {
            this.bean1 = bean1;
            System.out.println(this.getClass() + CONSTRUCTOR);
        }

        @Override
        public void destroy() {
            System.out.println(this.getClass() + DESTROY);
        }
    }

    @Data
    public static class Bean3 implements DisposableBean {

        private Bean2 bean2;

        /**
         * 创建 bean3 的时候需要传入一个 bean2 对象，对 bean2 产生了强依赖
         *
         * @param bean2 bean2
         */
        public Bean3(Bean2 bean2) {
            this.bean2 = bean2;
            System.out.println(this.getClass() + CONSTRUCTOR);
        }

        @Override
        public void destroy() {
            System.out.println(this.getClass() + DESTROY);
        }
    }

}
