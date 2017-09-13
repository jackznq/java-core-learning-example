package org.javacore.pattern.decorator;

/**
 * Created by ddfhznq on 2017/9/13.
 */
public class Window implements Component {
    @Override
    public void operation() {
        System.out.println("添加窗口");
    }
}
