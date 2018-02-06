package org.javacore.pattern.state.account;

/**
 * Created by znq on 2018/2/6.
 */
public class Client {

    public static void main(String[] args) {
//        Context context = new Context(1);
//        context.changeState();
//        context.request();
        Account acc = new Account("段誉", 0.0);
        acc.deposit(1000);
        acc.withdraw(2000);
        acc.deposit(3000);
        acc.withdraw(4000);
        acc.withdraw(1000);
        acc.computeInterest();
    }
}
