package com.wangguangwu.demo3;

import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean 实现类
 *
 * @author wangguangwu
 */
public class UserFactoryBean implements FactoryBean<UserModel> {

    int count = 1;

    /**
     * 返回创建好的对象
     */
    @Override
    public UserModel getObject() {
        UserModel userModel = new UserModel();
        userModel.setName("我是通过 FactoryBean 创建的第" + count++ + "对象");
        return userModel;
    }

    /**
     * 返回要创建的对象的类型
     */
    @Override
    public Class<?> getObjectType() {
        return UserModel.class;
    }

    @Override
    public boolean isSingleton() {
        // 改为 false 之后，每次都会创建一个新的对象
        return true;
    }
}
