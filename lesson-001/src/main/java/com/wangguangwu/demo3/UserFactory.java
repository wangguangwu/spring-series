package com.wangguangwu.demo3;

/**
 * 定义一个实例工厂
 *
 * @author wangguangwu
 */
public class UserFactory {

    public UserModel buildUser1() {
        System.out.println("==================静态无参方法===================");
        UserModel userModel = new UserModel();
        userModel.setName("bean实例方法创建的对象!");
        return userModel;
    }

    public UserModel buildUser2(String name, int age) {
        System.out.println("==================静态有参方法===================");
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setAge(age);
        return userModel;
    }

}
