package org.javacore.thread.oneByOne;

public class B implements  Runnable{
    @Override
    public void run() {
        System.out.println("我是线程B");
    }
}
