package org.javacore.pattern.simplefactory;

/**
 * Created by ddfhznq on 2017/9/12.
 */
public class CashRebate implements CashSuper {

    private double moneyRate;

    CashRebate(double moneyRate) {
        this.moneyRate = moneyRate;
    }

    @Override
    public double acceptCash(double money) {
        return moneyRate * money;
    }
}
