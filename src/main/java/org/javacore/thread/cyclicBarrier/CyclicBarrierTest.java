package org.javacore.thread.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * 栅栏测试
 * Created by ddfhznq on 2017/9/11.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread(() -> {

            try{
                cyclicBarrier.await();
            }catch (Exception e){

            }
            System.out.println(1);
        }).start();

        try{
            cyclicBarrier.await();
        }catch (Exception e){

        }
        System.out.println(2);
    }
}
