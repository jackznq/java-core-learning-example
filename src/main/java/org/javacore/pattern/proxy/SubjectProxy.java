package org.javacore.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *  代理类
 * Created by ddfhznq on 2017/9/4.
 */
public class SubjectProxy implements InvocationHandler {

    private Object object;

    public SubjectProxy(Object o){
        object = o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        method.invoke(object,args);
        System.out.println("after");
        return null;
    }

}
