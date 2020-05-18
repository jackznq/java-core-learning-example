package org.javacore.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: java-core-learning-example
 * @description: B
 * @author: znq
 * @create: 2020-05-14 13:19
 **/
@Component
public class B {

    @Autowired
    private A a;
    public B() {
        System.out.println("B");
    }
}
