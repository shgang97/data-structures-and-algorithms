package com.shg.dynamicprogramming.sequencedp.sellstock4;

import com.shg.utils.Arrays;
import com.shg.utils.Randoms;

/**
 * @author: shg
 * @date 2022/4/3 9:19 下午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] arr = Randoms.getRandomArray(100, 20);
        int[] arr = {3,2, 6, 5, 0, 3};
        Arrays.printArray(arr);
        System.out.println(s.maxProfit(2, arr));
    }
}

/**
 * 188. 买卖股票的最佳时机 IV
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }

        int n = prices.length;
        int[] f = new int[k << 1];

        //init
        for (int i = 0; i < k; i++) {
            f[i << 1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < f.length; j += 2) {
                // 对于第i天第j次第买入 = max(i -1天第 j 次买入， i - 1天第j - 1次卖出 - 当天的价格）
                if (j == 0) {
                    f[j] = Math.max(f[j], -prices[i]);
                } else {
                    f[j] = Math.max(f[j], f[j - 1] - prices[i]);
                }
                // 对于第i天第j次第卖出 = max(i -1天第 j / 2次卖出， i - 1天第j次买入 + 当天的价格
                f[j + 1] = Math.max(f[j + 1], f[j] + prices[i]);
            }
        }
        return f[f.length - 1];
    }

    public int maxProfit1(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }

        int n = prices.length;
        int[][][] f = new int[n][k][2];

        //init
        for (int i = 0; i < k; i++) {
            f[0][i][0] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                // 对于第i天第j次第买入 = max(i -1天第 j 次买入， i - 1天第j - 1次卖出 - 当天的价格）
                if (j == 0) {
                    f[i][j][0] = Math.max(f[i - 1][j][0], -prices[i]);
                } else {
                    f[i][j][0] = Math.max(f[i - 1][j][0], f[i][j - 1][1] - prices[i]);
                }
                // 对于第i天第j次第卖出 = max(i -1天第 j 次卖出， i - 1天第j次买入 + 当天的价格
                f[i][j][1] = Math.max(f[i - 1][j][1], f[i][j][0] + prices[i]);
            }
        }
        return f[n - 1][k - 1][1];
    }
}