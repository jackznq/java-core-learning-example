package org.javacore.pattern.facade;

/**
 *  外观类
 *  外观模式主要的目的是降低客户端与服务器的交互，
 *  客户端需要访问服务器只需要通过外观类操作即可。
 *
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
