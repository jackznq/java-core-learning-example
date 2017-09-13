package org.javacore.pattern.simplefactory;

/**
 * Created by ddfhznq on 2017/9/12.
 */
public class Client {

    public static void main(String [] args){
        CashSuper cashSuper = CashFactory.createCashAccept("正常收费");
        System.out.println(cashSuper.acceptCash(100));
    }
}
