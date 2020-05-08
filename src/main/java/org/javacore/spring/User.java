package org.javacore.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by ddfhznq on 2017/11/7.
 */
@Component
public class User implements InitializingBean, DisposableBean {

    private String name;

    private int age;

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User() {
        System.out.println("user init....");
    }

    public User(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        System.out.println("user init...." + name + age + sex);
    }

    @Override
    public String toString() {
        return "User{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", sex='" + sex + '\'' +
            '}';
    }

    public void init() {
        System.out.println("user init.....");

    }

    @PostConstruct
    public void myInit() {
        System.out.println("user PostConstruct.....");

    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("user PreDestroy.....");

    }

    public void myDestroy() {
        System.out.println("user myDestroy.....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("user afterPropertiesSet.....");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("user DisposableBean.....");
    }

//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("postProcessBeforeInitialization " + beanName + "=>>" + bean);
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("postProcessAfterInitialization " + beanName + "=>>" + bean);
//        return bean;
//    }
}
