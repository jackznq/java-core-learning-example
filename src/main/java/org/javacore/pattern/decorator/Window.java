package org.javacore.pattern.decorator;

//窗体类：具体构件类
public class Window implements Component {
    public void display() {
        System.out.println("显示窗体！");
    }
}
