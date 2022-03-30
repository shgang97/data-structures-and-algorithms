package com.shg.dynamicprogramming.uniquepaths;

/**
 * @author: shg
 * @create: 2022-03-30 8:01 下午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(3, 7));
    }

}

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[] f = new int[n];
        for (int i = 0; i < f.length; i++) {
            f[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[j] = f[j - 1] + f[j];
            }
        }
        return f[n - 1];
    }

    private int method1(int m, int n) {
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i < f.length; i++) {
            f[i][0] = 0;
        }
        for (int i = 1; i < f[0].length; i++) {
            f[0][i] = 0;
        }

        f[1][1] = 1;

        for (int i = 1; i < f.length; i++) {
            for (int j = 1; j < f[i].length; j++) {
                if (i == 1 && j == 1) continue;
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m][n];
    }
}
/**
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 *
 * 示例 2：
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 *
 * 示例 3：
 * 输入：m = 7, n = 3
 * 输出：28
 *
 * 示例 4：
 * 输入：m = 3, n = 3
 * 输出：6
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 */
