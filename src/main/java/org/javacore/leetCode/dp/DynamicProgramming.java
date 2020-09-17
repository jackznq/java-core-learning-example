package org.javacore.leetCode.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: java-core-learning-example
 * @description: 动态规划
 * @author: znq
 * @create: 2020-05-07 16:16
 **/
public class DynamicProgramming {

    public static void main(String[] args) {
        int[] dp = {7, 1, 5, 3, 6, 4};
//        maxProfit(dp);
        int[] items = {2, 2, 4, 6, 3}; // 物品的重量
        int[] value = {3, 4, 8, 9, 6}; // 物品的价值
        int n = 5; // 物品个数
        int w = 9; // 背包承受的最大重量
//        knapsack3(items, value, n, w);
        int profit[] = {1, 2, 3};
        int cost[] = {0, 1, 1};
//        System.out.println(findMaximizedCapital(2,0,profit,cost));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int buy = -prices[0];
        int sell = 0;
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

    /**
     * int[] items = {2,2,4,6,3}; // 物品的重量
     * int[] value = {3,4,8,9,6}; // 物品的价值
     * int n = 5; // 物品个数
     * int w = 9; // 背包承受的最大重量
     *
     * @param weight
     * @param value
     * @param n
     * @param w
     * @return
     */
    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        for (int i = 0; i < n; ++i) { // 初始化states
            for (int j = 0; j < w + 1; ++j) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        states[0][weight[0]] = value[0];
        for (int i = 1; i < n; ++i) { //动态规划，状态转移
            for (int j = 0; j <= w; ++j) { // 不选择第i个物品
                if (states[i - 1][j] >= 0) states[i][j] = states[i - 1][j];
                System.out.println(states[i][j]);
            }
            for (int j = 0; j <= w - weight[i]; ++j) { // 选择第i个物品
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                System.out.print(states[i][j] + " ");
            }
            System.out.println();
        }
        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n - 1][j] > maxvalue) maxvalue = states[n - 1][j];
        }
        return maxvalue;
    }

    /**
     * TODO
     *
     * @param grid
     * @return
     */
    public static int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] res = new int[row][col];
        res[0][0] = grid[0][0];

        return res[row - 1][col - 1];
    }

    /**
     * 62
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = 1;
        }

        Arrays.fill(res[0], 1);

        for (int i = 1; i < res.length; i++) {
            for (int j = 1; j < res[0].length; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m - 1][n - 1];
    }

    /**
     * 63 //// TODO: 2020-05-07
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[][] res = new int[m][n];
        return 0;
    }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Project[] projects = new Project[Profits.length];
        for (int i = 0; i < projects.length; i++) {
            projects[i] = new Project(Capital[i], Profits[i]);
        }
        PriorityQueue<Project> minCost = new PriorityQueue((Comparator<Project>) (o1, o2) -> o1.cost - o2.cost);
        PriorityQueue<Project> maxProfit = new PriorityQueue((Comparator<Project>) (o1, o2) -> o2.profit - o1.profit);

        for (int i = 0; i < projects.length; i++) {
            minCost.add(projects[i]);
        }

        for (int i = 0; i < k; i++) {
            while (!minCost.isEmpty() && minCost.peek().cost <= W) {
                maxProfit.add(minCost.poll());
            }
            if (maxProfit.isEmpty()) {
                return W;

            }
            W += maxProfit.poll().profit;
        }

        return W;
    }

    static class Project {
        private int cost;
        private int profit;

        public Project(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }


}
