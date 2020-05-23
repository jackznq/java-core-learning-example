package org.javacore.spi;

public class ConstClass {
    static {
        System.out.println("ConstClass init!....");
    }




    protected static final String HELLOWORLD = "hello world";
    public static int i = 1;
    static {
        i = 2;
    }

    static class SubClass extends ConstClass {
        public static int j =i;
    }
}
