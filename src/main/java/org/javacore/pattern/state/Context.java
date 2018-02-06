
package org.javacore.pattern.state;

import lombok.Data;

/**
 * 环境类又称为上下文类
 * <p>
 * Created by znq on 2018/2/6.
 */
@Data
public class Context {

    private State state;

    private int value;

    public Context(int value) {
        this.value = value;
    }

    public void request() {
        //其他代码
        state.handle(); //调用状态对象的业务方法
        //其他代码
    }

    public void changeState() {
        if (value == 0) {
            setState(new ConcreteStateA());
        } else
            setState(new ConcreteStateB());
    }
}
