package org.javacore.pattern.simplefactory;

/**
 *  正常收费
 * Created by ddfhznq on 2017/9/12.
 */
public class CashNormal implements CashSuper {

    @Override
    public double acceptCash(double money) {
        return money;
    }
}
