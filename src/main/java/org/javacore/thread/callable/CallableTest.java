package org.javacore.thread.callable;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *  callable 测试
 * Created by ddfhznq on 2017/11/14.
 */
public class CallableTest {

    public static void main(String[] args) throws Exception{
        List<Future<Integer>> futures = Lists.newArrayList();

        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0;i<10;i++) {
            futures.add(service.submit(new MyTask((int)(Math.random()*100))));
        }
        int sum =0;
        for (Future<Integer>f :futures) {
            sum+=f.get();
        }
        System.out.println(sum);
        service.shutdown();
    }
}
