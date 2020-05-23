package org.javacore.spi;

public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
        System.out.println(ConstClass.i);
        System.out.println(ConstClass.SubClass.i);
        System.out.println(ConstClass.SubClass.j);
        System.gc();
    }
}
