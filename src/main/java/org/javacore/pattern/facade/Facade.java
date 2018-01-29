package org.javacore.pattern.facade;

/**
 * 外观类
 * Created by znq on 2018/1/29.
 */
public class Facade {

    SubSystemOne one;

    SubSystemTwo two;

    SubSystemThree three;

    public Facade() {
        this.one = new SubSystemOne();
        this.two = new SubSystemTwo();
        this.three = new SubSystemThree();
    }

    public void methodA(){
        System.out.println("组合A");
        one.methodOne();
        three.methodThree();
        two.methodTwo();
    }

    public void methodB(){
        System.out.println("组合B");
        three.methodThree();
        two.methodTwo();
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();

    }
}
