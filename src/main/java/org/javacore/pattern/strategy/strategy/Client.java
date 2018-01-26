package org.javacore.pattern.strategy.strategy;

/**
 *  策略模式测试
 * Created by ddfhznq on 2018/1/24.
 */
public class Client {

    public static void main(String[] args) {
        double price =100;
        MovieTicket.Discount studentDiscount = new MovieTicket.StudentDiscount();
        System.out.println(studentDiscount.calculate(price));
    }
}
