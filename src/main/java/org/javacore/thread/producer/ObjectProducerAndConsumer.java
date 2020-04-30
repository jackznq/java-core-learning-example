package org.javacore.thread.producer;

/**
 * @program: java-core-learning-example
 * @description: wait()&notify()
 * @author: znq
 * @create: 2020-04-29 17:51
 **/
public class ObjectProducerAndConsumer {

    private static Object lock = new Object();

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 3; i++) {
            new ObjectConsumer().start();
        }
        Thread.sleep(1000);
        new ObjectProducer().start();
        new ObjectProducer().start();

    }


    static class ObjectProducer extends Thread {
        @Override
        public void run() {

            while (true) {
                synchronized (lock) {
                    System.out.println("线程" + getName() + "拿到锁");
                    lock.notify();
                }
            }
        }
    }

    static class ObjectConsumer extends Thread {
        @Override
        public void run() {

            while (true) {
                synchronized (lock) {
                    System.out.println("线程" + getName() + "等待");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程" + getName() + "执行结束");
            }
        }
    }
}

