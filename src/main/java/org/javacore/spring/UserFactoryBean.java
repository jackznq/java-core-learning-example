package org.javacore.spring;

import org.springframework.beans.factory.FactoryBean;

/**
 *  factoryBean
 * Created by ddfhznq on 2017/11/7.
 */
public class UserFactoryBean implements FactoryBean<User>{

    private String userInfo;

    @Override
    public User getObject() throws Exception {
        User user = new User();
        String userInfos[] =userInfo.split(",");
        user.setAge(Integer.valueOf(userInfos[1]));
        user.setName(userInfos[0]);
        user.setSex(userInfos[2]);
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }
}
