package com.wangguangwu.demo3;

/**
 * 创建一个静态工厂类，用于生成 UserModel 对象。
 *
 * @author wangguangwu
 */
public class UserStaticFactory {

    /**
     * 静态无参方法创建 userModel
     */
    public static UserModel buildUser1() {
        System.out.println(UserStaticFactory.class + ".buildUser1()");

        UserModel userModel = new UserModel();
        userModel.setName("我是无参静态构造方法创建的！");
        return userModel;
    }

    /**
     * 静态有参方法创建 userModel
     */
    public static UserModel buildUser2(String name, int age) {
        System.out.println(UserStaticFactory.class + ".buildUser2()");

        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setAge(age);
        return userModel;
    }

    private UserStaticFactory() {
    }

}


