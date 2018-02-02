package org.javacore.pattern.simplefactory;

/**
 * Created by znq on 2018/2/2.
 */
public abstract class AbstractProduct implements Product {

    @Override
    public void methodSame() {
        System.out.println("相同部分");
    }
    
}
