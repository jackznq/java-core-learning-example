package org.javacore.stream;

import java.util.concurrent.RecursiveTask;

/**
 * @program: java-core-learning-example
 * @description: fork join
 * @author: znq
 * @create: 2020-03-14 19:56
 **/
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private final long[] numbers;    //←─要求和的数组
    private final int start;    //←─子任务处理的数组的起始和终止位置
    private final int end;

    public static final long THRESHOLD = 10_00000;   // ←─不再将任务分解为子任务的数组大小

    public ForkJoinSumCalculator(long[] numbers) {    //←─公共构造函数用于创建主任务
        this(numbers, 0, numbers.length);
    }

    public ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        ForkJoinSumCalculator left = new ForkJoinSumCalculator(numbers, start, start + length / 2);
        left.fork();
        ForkJoinSumCalculator right = new ForkJoinSumCalculator(numbers, length / 2 + start, end);
        Long rightR = right.compute();
        Long leftR = left.join();
        return rightR + leftR;
    }

    private long computeSequentially() {    //←─在子任务不再可分时计算结果的简单算法
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }




}
