package com.shg.dynamicprogramming.sequencedp.painthouse;

/**
 * @author: shg
 * @date 2022/3/31 8:04 下午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] costs = {
                {1, 2, 3},
                {1, 4, 6}
        };
        System.out.println(s.minCost(costs));
    }
}

/**
 * 515 · 房屋染色
 * 描述
 * 这里有n个房子在一列直线上，现在我们需要给房屋染色，分别有红色蓝色和绿色。每个房屋染不同的颜色费用也不同，你需要设计一种染色方案使得相邻的房屋颜色不同，并且费用最小，返回最小的费用。
 * 费用通过一个nx3 的矩阵给出，比如cost[0][0]表示房屋0染红色的费用，cost[1][2]表示房屋1染绿色的费用，依此类推。找到油漆所有房子的最低成本。
 * <p>
 * 来源：lintcode
 * 链接：https://www.lintcode.com/problem/515/
 */
class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int[][] f = new int[n][3];
        f[0][0] = costs[0][0];
        f[0][1] = costs[0][1];
        f[0][2] = costs[0][2];

        for (int i = 1; i < n; i++) {
            f[i][0] = costs[i][0] + Math.min(f[i - 1][1], f[i - 1][2]);
            f[i][1] = costs[i][1] + Math.min(f[i - 1][0], f[i - 1][2]);
            f[i][2] = costs[i][2] + Math.min(f[i - 1][0], f[i - 1][1]);
        }
        return Math.min(Math.min(f[n - 1][0], f[n - 1][1]), f[n - 1][2]);

    }
}