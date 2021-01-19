package org.javacore.thread;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @className: Test
 * @description: TODO 类描述
 * @author: znq
 * @date: 2021-01-18
 **/
public class OrderPrint {


    //需要打印的数字
    private int N;
    //线程总数
    private int mc;

    private AtomicLong num = new AtomicLong(1);

    private class PrintRunnable implements Runnable {

        private final int NUMBER;

        public PrintRunnable(int number) {
            this.NUMBER = number;
        }

        @Override
        public void run() {
            //while循环保证线程处于执行状态，获取CPU时间
            while (true) {
                //如果不是自己执行打印，自旋等待
                //因为每次读取VC时都需要读取最新的值，所以VC为volatile修饰
                while (num.get() % mc != NUMBER) {//自旋
                    //自旋过程中发现已经打印到N，则结束线程
                    if (num.get() > N) {
                        System.out.println("break:" + N);
                        return;
                    }
                }
                //确定需要自己打印，获取内置锁
                synchronized (OrderPrint.class) {
                    //二次判断，如果已经打印到N，结束线程
                    if (num.get() > N) {
                        break;
                    }
                    //打印，并且更新VC
                    System.out.println(Thread.currentThread().getName() + " " + num.get() + " " + NUMBER);
                    num.addAndGet(1);
                }
            }
        }
    }

    //函数初始化mc个线程，并且启动所有的线程
    public void printSeqNum(int N, int mc) {
        this.N = N;
        this.mc = mc;
        for (int i = 0; i < mc; ++i) {
            new Thread(new PrintRunnable(i)).start();
        }
    }

    //main函数作为测试用例
    public static void main(String[] args) {
        OrderPrint print = new OrderPrint();
        print.printSeqNum(101, 7);
    }
}
