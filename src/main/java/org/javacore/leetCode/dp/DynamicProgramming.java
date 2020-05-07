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

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] res = new int[row][col];
        res[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            res[i][0] = res[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < col; j++) {
            res[0][j] = res[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
            }
        }
        return res[row - 1][col - 1];
    }

    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = 1;
        }

        for (int i = 0; i < res[0].length; i++) {
            res[0][i] = 1;
        }

        for (int i = 1; i < res.length; i++) {
            for (int j = 1; j < res[0].length; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m - 1][n - 1];
    }
}
