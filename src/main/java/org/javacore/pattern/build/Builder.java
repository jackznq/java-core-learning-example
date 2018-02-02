package org.javacore.pattern.build;

/**
 * 建造者抽象类
 * Created by znq on 2018/1/30.
 */
public interface Builder {

    void buildPartA();

    void buildPartB();

    void buildPartC();

    Product getProduct();
}
