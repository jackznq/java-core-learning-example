package org.javacore.netty.futures;

import java.util.concurrent.*;

/**
 * futures
 * Created by ddfhznq on 2017/11/15.
 */
public class FutureExample {

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        Runnable run = () -> {
            System.out.println("task1");
        };
        Callable<Integer> callable = () -> (int) (Math.random()*100);

        Future<?> f1 = service.submit(run);
        Future<Integer> f2 = service.submit(callable);
        System.out.println(f1.isDone());
        System.out.println(f2.isDone());
        while (f1.isDone()) {
            System.out.println("f1 is complete");
            break;
        }
        while (f2.isDone()) {
            System.out.println("f2 is complete" + f2.get());
            break;
        }
    }
}
