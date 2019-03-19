package org.javacore.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author SnailClimb
 * @date 2018年10月30日
 * @Description: 多个线程之间不共享变量线程安全的情况
 */
public class MyThread extends Thread {

    private AtomicInteger count = new AtomicInteger(5);

    public MyThread() {
        super();
    }

    @Override
    public void run() {
        super.run();
//        while (count > 0) {
        System.out.println("由 " + MyThread.currentThread().getName() + " 计算，count=" + count.decrementAndGet());
//        }
    }

    public static void main(String[] args) {
//        MyThread a = new MyThread("A");
//        MyThread b = new MyThread("B");
//        MyThread c = new MyThread("C");
//        MyThread d = new MyThread("D");
//        MyThread e = new MyThread("E");
//        MyThread f = new MyThread("F");
        MyThread share = new MyThread();
        Thread a = new Thread(share);
        Thread b = new Thread(share);
        Thread c = new Thread(share);
        Thread d = new Thread(share);
        Thread e = new Thread(share);
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
