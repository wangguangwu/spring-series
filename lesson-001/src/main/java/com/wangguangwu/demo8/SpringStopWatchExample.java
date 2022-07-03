package com.wangguangwu.demo8;

import org.springframework.util.StopWatch;

/**
 * @author wangguangwu
 */
public class SpringStopWatchExample {

    public static void main(String[] args) throws InterruptedException {
        test1();
        System.out.println("=================================");
        test2();
        System.out.println("=================================");
        test3();
    }

    private static void test3() throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start("A");
        Thread.sleep(1000);
        sw.stop();
        System.out.println(sw.getLastTaskTimeMillis());
    }

    /**
     * 格式打印出的所有任务的耗时以及占比
     */
    private static void test2() throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start("A");
        Thread.sleep(500);
        sw.stop();
        sw.start("B");
        Thread.sleep(300);
        sw.stop();
        sw.start("C");
        Thread.sleep(200);
        sw.stop();
        System.out.println(sw.prettyPrint());
    }

    /**
     * 统计输出总耗时
     */
    private static void test1() throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start();
        //long task simulation
        Thread.sleep(1000);
        sw.stop();
        System.out.println("执行时间：" + sw.getTotalTimeMillis());
    }

}
