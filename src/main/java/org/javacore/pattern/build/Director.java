package org.javacore.pattern.build;

/**
 * Created by znq on 2018/1/30.
 */
public class Director {

    public void construct(Builder builder){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }
}
