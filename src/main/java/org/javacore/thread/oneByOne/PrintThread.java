package org.javacore.thread.oneByOne;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * className: PrintThread
 * Package: org.javacore.thread.oneByOne
 * Description:
 * Author:znq
 * Date 19/5/9 下午4:24
 */
public class PrintThread implements Runnable {
    private String symbol;
    private Condition conditionA = null;
    private int go = 0;
    private ReentrantLock lock = null;
    //使用原子类，本例中并没有多大意义
    private static AtomicInteger i = new AtomicInteger(0);

    public PrintThread(String symbol, Condition conditionA, int go, ReentrantLock lock) {
        this.symbol = symbol;
        this.lock = lock;
        this.conditionA = conditionA;
        this.go = go;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                while (i.get() % 3 != go) {
                    conditionA.await();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //防止过多输出
            if (i.get() == 3) {
                lock.unlock();
                break;
            }
            System.out.println("result " + symbol);
            i.getAndIncrement();
//            System.out.println(i.get());
            //可以试试signalAll或signal区别，比较时建议去掉前面的break
            conditionA.signal();
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();

        new Thread(new PrintThread("A", conditionA, 0, lock)).start();
        new Thread(new PrintThread("B", conditionA, 1, lock)).start();
        new Thread(new PrintThread("C", conditionA, 2, lock)).start();
    }

}
