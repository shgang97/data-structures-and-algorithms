package com.shg.dynamicprogramming.divideddp.perfectsquares;

/**
 * @author: shg
 * @date 2022/5/12 8:12 下午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.numSquares(12);
        System.out.println(i);

    }
}

/**
 * 279. 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/perfect-squares/
 */
class Solution {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                f[i] = Math.min(f[i], f[i - j * j] + 1);
            }
        }
        return f[n];
    }
}