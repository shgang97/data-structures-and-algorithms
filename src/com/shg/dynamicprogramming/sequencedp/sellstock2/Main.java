package com.shg.dynamicprogramming.sequencedp.sellstock2;

import com.shg.utils.Arrays;
import com.shg.utils.Randoms;

/**
 * @author: shg
 * @date 2022/4/3 8:17 下午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = Randoms.getRandomArray(100, 50);
        Arrays.printArray(arr);
        System.out.println(s.maxProfit(arr));
    }
}

/**
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。
 * 在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }
}