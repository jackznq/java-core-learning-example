package org.javacore.pattern.simplefactory;

/**
 * Created by ddfhznq on 2017/9/12.
 */
public class Client {

    public static void main(String [] args){
        Product product = SimpleFactory.getProduct("A");
        product.methodSame();
        product.methodDiff();
        Product B = SimpleFactory.getProduct("B");
        B.methodSame();
        B.methodDiff();
    }
}
