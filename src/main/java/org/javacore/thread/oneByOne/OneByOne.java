package org.javacore.thread.oneByOne;

//多线程轮流打印两个线程的信息
public class OneByOne {
    public static void main(String[] args)throws Exception {
        while (true){
            Thread thread = new Thread(new A());
            thread.start();
            thread.join();
            Thread thread1 = new Thread(new B());
            thread1.start();

            thread1.join();
        }


    }
}

