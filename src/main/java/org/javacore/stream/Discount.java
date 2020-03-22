package org.javacore.stream;

import static org.javacore.stream.Shop.delay;

public class Discount {
    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    // Discount类的具体实现这里暂且不表示，参见代码清单11-14
    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " +
            Discount.apply(quote.getPrice(),    //←─将折扣代码应用于商品最初的原始价格
                quote.getDiscountCode());
    }

    private static double apply(double price, Code code) {
        delay();                                              //←─模拟Discount服务响应的延迟
        return price * (100 - code.percentage) / 100;
    }
}
