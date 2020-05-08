package org.javacore.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @program: java-core-learning-example
 * @description: 后置处理器
 * @author: znq
 * @create: 2020-05-08 12:56
 **/
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization " + beanName + "=>>" + bean);
//        if (bean instanceof User) {
//            User user = (User) bean;
//            user.setAge(30);
//            user.setName("znq");
//            return user;
//        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization " + beanName + "=>>" + bean);
//        if (bean instanceof User) {
//            User user = (User) bean;
//            user.setAge(35);
//            user.setName("znq1");
//            user.setSex("1");
//            return user;
//        }
        return bean;
    }
}
