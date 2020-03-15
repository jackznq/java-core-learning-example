package org.javacore.stream;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;

/**
 * @program: java-core-learning-example
 * @description: 流
 * @author: znq
 * @create: 2020-03-11 16:35
 **/
public class StreamTest {
    public static void main(String[] args) {
//        rangeClosed();
//        gougu();
//        fibo();
//        join();
//        System.out.println("Sequential sum done in:" +
//            measureSumPerf(StreamTest::sequenceSum, 10000000) + " msecs");
//        System.out.println("rangedSum sum done in:" +
//            measureSumPerf(StreamTest::rangedSum, 10000000) + " msecs");
        System.out.println("fork join  sum done in:" +
            measureSumPerf(StreamTest::forkJoinSum, 10000000) + " msecs");

    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }

    public static void rangeClosed() {
        IntStream intStream = IntStream.range(1, 200).filter(e -> e % 2 == 1);
        System.out.println(intStream.count());
    }

    public static void gougu() {
        Stream<int[]> pythagoreanTriples =
            IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                    IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b ->
                            new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                ).filter(c -> c[2] % 1 == 0 && c[2] < 100);
//        pythagoreanTriples.forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));
        System.out.println(pythagoreanTriples.count());

    }

    public static void fibo() {
        Stream.iterate(new int[]{0, 1},
            t -> new int[]{t[1], t[0] + t[1]})
            .limit(20)
            .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
    }

    public static void join() {
        String join = transactions.stream().map(e -> e.getTrader().getName()).collect(joining(" "));
        System.out.println(join);
        String s = transactions.stream().map(e -> e.getTrader().getName()).collect(reducing((s1, s2) -> s1 + s2)).get();
        System.out.println(s);
    }

    static {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950));
    }

    public static List<Transaction> transactions;


    /**
     * 是否是质数
     *
     * @param candidate
     * @return
     */
    public static boolean prime(int candidate) {
        int sqrt = (int) Math.sqrt(candidate);
        return IntStream.range(2, sqrt).noneMatch(i -> candidate % i == 0);
    }

    public static Long sequenceSum(long n) {
        return Stream.iterate(0L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }

    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
            .reduce(0L, Long::sum);
    }
}
