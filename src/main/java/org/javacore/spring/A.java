package org.javacore.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: java-core-learning-example
 * @description: A
 * @author: znq
 * @create: 2020-05-14 13:19
 **/
@Component
public class A {

    @Autowired
    private B b;

    public A() {
        System.out.println("A");
    }

    public void printA() {

        System.out.println("print A");
    }
}
