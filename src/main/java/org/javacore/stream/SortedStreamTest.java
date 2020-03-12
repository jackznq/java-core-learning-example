package org.javacore.stream;

/*
 * Copyright [2015] [Jeff Lee]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class SortedStreamTest {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950));

        //找出2011年发生的所有交易，并按交易额排序（从低到高）。
        System.out.println(transactions.stream().filter(e -> e.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(toList()));
        //交易员都在哪些不同的城市工作过？
        System.out.println(transactions.stream().map(e -> e.getTrader().getCity()).distinct().collect(toList()));
        //查找所有来自于剑桥的交易员，并按姓名排序。
        System.out.println(transactions.stream().map(Transaction::getTrader).filter(e -> e.getCity().equals("Cambridge")).distinct().sorted(Comparator.comparing(Trader::getName)).collect(toList()));
        //返回所有交易员的姓名字符串，按字母顺序排序。
        System.out.println(transactions.stream().map(e -> e.getTrader().getName()).distinct().sorted().collect(Collectors.joining()));
        //有没有交易员是在米兰工作的？
        System.out.println(transactions.stream().anyMatch(e -> e.getTrader().getCity().equals("Milan")));
        //打印生活在剑桥的交易员的所有交易额。
        System.out.println(transactions.stream().filter(e -> e.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).reduce(Integer::sum).get());
        //所有交易中，最高的交易额是多少？
        System.out.println(transactions.stream().max(Comparator.comparing(Transaction::getValue)).get());
        System.out.println(transactions.stream().map(Transaction::getValue).reduce(Integer::max).get());

        IntSummaryStatistics collect = transactions.stream().collect(summarizingInt(Transaction::getValue));
        System.out.println();
    }
}

class Trader {

    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}

class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return "{" + this.trader + ", " +
            "year: " + this.year + ", " +
            "value:" + this.value + "}";
    }
}
