package org.javacore.classloader;

import org.javacore.base.String.Demo;

import java.util.Objects;

/**
 * 类加载顺序验证
 * Created by ddfhznq on 2017/11/4.
 */
public class StaticValidator {

    public static int i = 2;

    public static int j = 2;


    static {
        i = 3;
        System.out.println(i);
    }

    public static void main(String[] args) throws Exception{
        i = 5;
        System.out.println(i);
        Class clazz = String.class;
//        Method[] methods = clazz.getDeclaredMethods();
        ClassLoader classLoader = clazz.getClassLoader();
        while (Objects.nonNull(classLoader)) {
//            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
//        System.out.println(classLoader);
        MyClassLoader myClassLoader = new MyClassLoader("D:/","znq");
        Class<?> c =myClassLoader.loadClass("org.javacore.base.String.Demo");
        Object object = c.newInstance();
        Demo demo =(Demo) object;
        System.out.println(object.getClass().getClassLoader());

        System.out.println(demo);
        }
}
