package org.javacore.leetCode.dp;

/**
 * @program: java-core-learning-example
 * @description: 动态规划
 * @author: znq
 * @create: 2020-05-07 16:16
 **/
public class DynamicProgramming {
    public static void main(String[] args) {
        int[] dp = {7, 1, 5, 3, 6, 4};
        maxProfit(dp);
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int buy = -prices[0], sell = 0;
        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, prices[i] + buy);
            buy = Math.max(buy, sell - prices[i]);
            System.out.println("sell: " + sell + " " + "buy: " + buy);
        }
        return sell;
    }
}
