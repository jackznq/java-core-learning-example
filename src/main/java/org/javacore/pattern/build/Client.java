package org.javacore.pattern.build;

/**
 * Created by znq on 2018/1/30.
 */
public class Client {

    public static void main(String[] args) {

        Director director = new Director();

        Builder A = new ConcreteBuilderA();
        Builder B = new ConcreteBuilderB();

        director.construct(A);
        Product proA = A.getProduct();
        proA.show();

        director.construct(B);
        Product proB =B.getProduct();
        proB.show();
    }
}
