package org.javacore.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 测试类
 * Created by ddfhznq on 2017/9/5.
 */
public class Client {

    public static void main(String[] args) {

        RealSubject realSubject = new RealSubject();
        InvocationHandler invocationHandler = new SubjectProxy(realSubject);
        Class clazz = realSubject.getClass();
        Class classes[] =clazz.getInterfaces();
        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println(classes);
        System.out.println(classLoader);
        Subject subject = (Subject) Proxy.newProxyInstance(classLoader, classes, invocationHandler);
        subject.Request();
    }
}
