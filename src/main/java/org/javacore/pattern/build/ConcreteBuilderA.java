package org.javacore.pattern.build;

/**
 * 具体的建造者
 * Created by znq on 2018/1/30.
 */
public class ConcreteBuilderA implements Builder {

    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("A");
    }

    @Override
    public void buildPartB() {
        product.add("B");
    }

    @Override
    public void buildPartC() {
        product.add("C");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
