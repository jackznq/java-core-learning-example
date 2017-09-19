package org.javacore.finaltest;

/**
 *
 * Created by ddfhznq on 2017/9/15.
 */
public class Client {
    FinalExample finalExample = new FinalExample();
    public static void main(String [] args){

        Worker worker = new Worker();
        Worker1 worker1 = new Worker1();
        new Thread(worker).start();

        new Thread(worker1).start();
    }

}
