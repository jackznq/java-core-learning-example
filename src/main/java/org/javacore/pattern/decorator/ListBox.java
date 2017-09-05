package org.javacore.pattern.decorator;

//列表框类：具体构件类
class ListBox implements Component {
    public void display() {
        System.out.println("显示列表框！");
    }
}
