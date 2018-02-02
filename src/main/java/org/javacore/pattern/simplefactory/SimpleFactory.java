package org.javacore.pattern.simplefactory;

/**
 * 工工長類
 * Created by znq on 2018/2/2.
 */
public class SimpleFactory {

    private static Product product;

    public static Product getProduct(String type) {
        if ("A".equals(type)) {
            product = new ProductA();
        }
        if ("B".equals(type)) {
            product = new ProductB();
        }

        return product;
    }
}
