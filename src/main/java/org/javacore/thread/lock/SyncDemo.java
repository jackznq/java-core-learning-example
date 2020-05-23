package org.javacore.thread.lock;

/**
 * @program: java-core-learning-example
 * @description: sync demo
 * @author: znq
 * @create: 2020-05-18 23:08
 **/
public class SyncDemo {

     static  Integer count =0;

    public static void incr(){
        synchronized (count){

            count++;
        }
    }

    public static void main(String[] args) {
        for (int i = 0;i<1000;i++){
            new Thread(()->incr()).start();
        }

        System.out.println(count);
    }
}
