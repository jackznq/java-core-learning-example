package org.javacore.pattern.state;

/**
 * Created by znq on 2018/2/6.
 */
public class ConcreteStateB implements State{

    @Override
    public void handle() {
        System.out.println("ConcreteStateB");
    }
}
