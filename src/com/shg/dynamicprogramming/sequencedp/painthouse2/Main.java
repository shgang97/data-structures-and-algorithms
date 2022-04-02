package com.shg.dynamicprogramming.sequencedp.painthouse2;

/**
 * @author: shg
 * @date 2022/4/2 6:34 下午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] costs = {
                {14}

        };
        System.out.println(s.minCostII(costs));
    }
}

/**
 * 516 · 房屋染色 II *
 * 题目题解笔记讨论排名
 * 描述
 * 这里有n个房子在一列直线上，现在我们需要给房屋染色，共有k种颜色。每个房屋染不同的颜色费用也不同，你希望每两个相邻的房屋颜色不同
 * 费用通过一个nxk 的矩阵给出，比如cost[0][0]表示房屋0染颜色0的费用，cost[1][2]表示房屋1染颜色2的费用。找到油漆所有房子的最低成本。
 * lintcode
 * 链接：https://www.lintcode.com/problem/516/
 */
class Solution {
    public int minCostII(int[][] costs) {
        // write your code here
        if (costs == null || costs.length == 0) {
            return 0;
        }
        if (costs.length == 1) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < costs[0].length; j++) {
                min = Math.min(costs[0][j],min);
            }
            return min;
        }

        int m = costs.length;
        int n = costs[0].length;
        int[][] f = new int[m + 1][n];
        for (int i = 0; i < n; i++) {
            f[0][i] = 0;
        }

        int j1 = 0, j2 = 0;

        for (int i = 1; i <= m; i++) {
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (f[i - 1][j] < min1) {
                    min2 = min1;
                    j2 = j1;
                    min1 = f[i - 1][j];
                    j1 = j;
                } else if (f[i - 1][j] < min2) {
                    min2 = f[i - 1][j];
                    j2 = j;
                }
            }
            for (int j = 0; j < n; j++) {
                if (j1 != j) {
                    f[i][j] = min1 + costs[i - 1][j];
                } else {
                    f[i][j] = min2 + costs[i - 1][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(f[m][j], min);
        }
        return min;
    }

}