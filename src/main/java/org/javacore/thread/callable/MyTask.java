package org.javacore.thread.callable;

import java.util.concurrent.Callable;

/**
 *  callable 创建线程
 * Created by ddfhznq on 2017/11/14.
 */
public class MyTask implements Callable<Integer>{

    private Integer data;
    MyTask(int data){
        this.data = data;
    }
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0;i<data;i++){
            sum +=i;
        }
        return sum;
    }
}
