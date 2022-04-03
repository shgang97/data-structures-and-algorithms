package com.shg.dynamicprogramming.sequencedp.sellstock;

import com.shg.utils.Arrays;
import com.shg.utils.Randoms;

/**
 * @author: shg
 * @date 2022/4/3 7:59 下午
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
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }

}