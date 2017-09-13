package org.javacore.pattern.decorator;

/**
 *  装饰模式测试类
 * Created by ddfhznq on 2017/9/13.
 */
public class Client {
    public static void main(String[] args) {
        Component component1,component2;
        component1 = new Window();
        component2 = new ConcreteDecorator(component1);
        component2 = new ConcreteDecoratorA(component2);
        component2.operation();
    }
}

