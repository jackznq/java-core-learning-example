package org.javacore.pattern.factorymethod;

/**
 * Created by znq on 2018/2/2.
 */
public class ConcreteFactory implements Factory{

    @Override
    public Product getProduct() {
        return new ConcreteProduct();
    }
}
