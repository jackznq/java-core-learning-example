package org.javacore.thread.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * 栅栏测试
 * Created by ddfhznq on 2017/9/11.
 */
public class CyclicBarrierTest {

    private static CyclicBarrier cyclicBarrier;
    static class SumCalculatorThread extends Thread{
        private int a;
        private int b;
        SumCalculatorThread(int a,int b){
            this.a=a;
            this.b=b;
            System.out.println("计算的值为"+sumResult(a,b));
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"计算完成");
            try {

                cyclicBarrier.await();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("计算完成，进行合并");
            }
        });
            new SumCalculatorThread(1,50).start();
            new SumCalculatorThread(51,100).start();
    }
    public static int sumResult(int a,int b){
        int total =0;
        for (int i=a;i<=b;i++){
            total+=i;
        }
        return total;
    }
}
