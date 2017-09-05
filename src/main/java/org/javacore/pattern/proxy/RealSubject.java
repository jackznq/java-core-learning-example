package org.javacore.pattern.proxy;

/**
 *  真是的类
 */
public class RealSubject implements Subject {

    @Override
    public void Request() {
        System.out.println("我是真正的要代理的对象");
    }
}
