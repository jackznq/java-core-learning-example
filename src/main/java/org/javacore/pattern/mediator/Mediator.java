package org.javacore.pattern.mediator;

import java.util.ArrayList;

/**
 * 用一个中介对象（中介者）来封装一系列的对象交互，
 * 中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
 * 中介者模式又称为调停者模式，它是一种对象行为型模式。
 * Created by znq on 2018/2/8.
 */
public abstract class Mediator {


    //声明抽象的业务方法
    abstract void componentChanged(Component c);
}
