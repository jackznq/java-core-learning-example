package org.javacore.pattern.observer;

import java.util.ArrayList;

/**
 * 战队控制中心类：目标类
 * Created by ddfhznq on 2017/9/5.
 */
public interface AllyControlCenter {

    ArrayList<Observer> players = new ArrayList<Observer>(); //定义一个集合用于存储战队成员

    void setAllyName(String allyName);

    String getAllyName();

    //注册方法
    void join(Observer obs);

    //注销方法
    void quit(Observer obs);

    //声明抽象通知方法
    void notifyObserver(String name);
}
