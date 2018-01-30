package org.javacore.pattern.build;

/**
 * 具体的建造者
 * Created by znq on 2018/1/30.
 */
public class ConcreteBuilderB implements Builder {

    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("X");
    }

    @Override
    public void buildPartB() {
        product.add("Y");
    }

    @Override
    public void buildPartC() {
        product.add("Z");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
