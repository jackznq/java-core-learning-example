package org.javacore.stream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
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
        System.out.println(prime(129));
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
        IntStream generate = IntStream.generate(() -> 1);
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
}
