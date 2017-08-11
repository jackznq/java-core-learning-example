package org.javacore.thread.oneByOne;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class AlternateRun2 implements Runnable {

    //线程编号
    private int num = 0;

    private Lock lock = new ReentrantLock();
    private Condition redCon = lock.newCondition();
    private Condition greenCon = lock.newCondition();

    public static void main(String[] args) {
        new AlternateRun2().run();
    }

    @Override
    public void run() {
        new Thread(new RedThread()).start();
        new Thread(new GreenThread()).start();
    }

    class RedThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (num != 0) {
                        redCon.await();
                    }
                    System.out.println(Thread.currentThread().getName() + "is red");
                    num = 2;
                    greenCon.signal();

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class GreenThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (num != 2) {
                        greenCon.await();
                    }
                    System.out.println(Thread.currentThread().getName() + "green ");
                    num = 0;
                    TimeUnit.SECONDS.sleep(1);
                    redCon.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
