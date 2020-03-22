package org.javacore.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.util.stream.Collectors.toList;

public class Shop {

    private static final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
        new Shop("LetsSaveBig"),
        new Shop("MyFavoriteShop"),
        new Shop("ShopEasy"),
        new Shop("BuyItAll"));


    private String name;

    private double price;

    public void setPrice(double price) {
        this.price = price;
    }

    public Shop(String name) {
        this.name = name;
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public static void delay() {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private double calculatePrice(String product) {
        delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);

    }

    private Future<Double> getPriceAsync(String product) {
//        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);   // ←─如果价格计算正常结束，完成Future操作并设置商品价格
            } catch (Exception ex) {
                futurePrice.completeExceptionally(ex);   // ←─否则就抛出导致失败的异常，完成这次Future操作
            }
        }).start();
        return futurePrice;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Executor executor =
            Executors.newFixedThreadPool(Math.min(shops.size(), 100),    //←─创建一个线程池，线程池中线程的数目为100和商店数目二者中较小的一个值
                r -> {
                    Thread t = new Thread(r);
                    t.setDaemon(true);    //←─使用守护线程——这种方式不会阻止程序的关停
                    return t;
                });
        long start = System.nanoTime();
        System.out.println(findPrices("myPhone27S",executor));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }

    private static List<String> findPrices(String product, Executor executor) {

        List<CompletableFuture<String>> collect = shops.stream().
            map(shop -> (CompletableFuture.supplyAsync(() -> shop.getName() + " price is " +
                shop.getPrice(product), executor))).collect(toList());
        return collect.stream().map(CompletableFuture::join).collect(toList());
    }


    public static List<String> findPrices(String product) {
        return shops.stream()
            .map(shop -> String.format("%s price is %.2f",
                shop.getName(), shop.getPrice(product)))
            .collect(toList());
    }
}
