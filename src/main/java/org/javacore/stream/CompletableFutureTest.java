package org.javacore.stream;

import java.util.concurrent.*;

/**
 * @program: java-core-learning-example
 * @description: 异步计算测试
 * @author: znq
 * @create: 2020-03-22 10:30
 **/
public class CompletableFutureTest {

    private static void java7Future(){
        ExecutorService executor = Executors.newCachedThreadPool();    //←─创建Executor-Service，通过它你可以向线程池提交任务
        Future future =  executor.submit(()-> System.out.println("df"));

        try {
            Object o = future.get(1, TimeUnit.SECONDS);//←─获取异步操作的结果，如果最终被阻塞，无法得到结果，那么在最多等待1秒钟之后退出
        } catch (ExecutionException ee) {
            // 计算抛出一个异常
        } catch (InterruptedException ie) {
            // 当前线程在等待过程中被中断
        } catch (TimeoutException te) {
            // 在Future对象完成之前超过已过期
        }
    }
}
