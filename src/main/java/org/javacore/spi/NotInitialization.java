package org.javacore.spi;

public class NotInitialization {
    public static void main(String[] args) {

        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }
}
