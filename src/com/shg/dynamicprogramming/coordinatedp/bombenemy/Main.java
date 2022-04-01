package com.shg.dynamicprogramming.coordinatedp.bombenemy;

/**
 * @author: shg
 * @date 2022/4/1 10:48 下午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] grid = {
                {'0', 'E', '0', '0'},
                {'E', '0', 'E', 'E'},
                {'0', 'E', '0', '0'}
        };
        System.out.println(s.maxKilledEnemies(grid));
    }
}

/**
 * 553 · 炸弹袭击
 * 题目题解笔记讨论排名
 * 描述
 * 给定一个二维矩阵, 每一个格子可能是一堵墙 W,或者 一个敌人 E 或者空 0 (数字 '0'), 返回你可以用一个炸弹杀死的最大敌人数. 炸弹会杀死所有在同一行和同一列没有墙阻隔的敌人。 由于墙比较坚固，所以墙不会被摧毁.
 * lintcode
 * 链接：https://www.lintcode.com/problem/553/
 */
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] totalKilledEnemies = new int[m][n];

        int[][] upKilledEnemies = killedUpEnemies(grid, m, n);
        int[][] downKilledEnemies = killedDownEnemies(grid, m, n);
        int[][] leftKilledEnemies = killedLeftEnemies(grid, m, n);
        int[][] rightKilledEnemies = killedRightEnemies(grid, m, n);

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    totalKilledEnemies[i][j] = upKilledEnemies[i][j]
                            + downKilledEnemies[i][j]
                            + leftKilledEnemies[i][j]
                            + rightKilledEnemies[i][j];
                    max = Math.max(totalKilledEnemies[i][j], max);
                }

            }
        }
        return max;
    }

    public int[][] killedUpEnemies(char[][] grid, int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (i > 0) {
                    f[i][j] += f[i - 1][j];
                }
                f[i][j] = grid[i][j] == 'W' ? 0 : f[i][j];
            }
        }
        return f;
    }

    public int[][] killedDownEnemies(char[][] grid, int m, int n) {
        int[][] f = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                f[i][j] = f[i][j] = grid[i][j] == 'E' ? 1 : 0;;
                if (i < m - 1) {
                    f[i][j] += f[i + 1][j];
                }
                f[i][j] = grid[i][j] == 'W' ? 0 : f[i][j];
            }
        }
        return f;
    }

    public int[][] killedLeftEnemies(char[][] grid, int m, int n) {
        int[][] f = new int[m][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                f[i][j] = f[i][j] = grid[i][j] == 'E' ? 1 : 0;;
                if (j > 0) {
                    f[i][j] += f[i][j - 1];
                }
                f[i][j] = grid[i][j] == 'W' ? 0 : f[i][j];
            }
        }
        return f;
    }

    public int[][] killedRightEnemies(char[][] grid, int m, int n) {
        int[][] f = new int[m][n];
        for (int j = n - 1; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                f[i][j] = f[i][j] = grid[i][j] == 'E' ? 1 : 0;;
                if (j < n - 1) {
                    f[i][j] += f[i][j + 1];
                }
                f[i][j] = grid[i][j] == 'W' ? 0 : f[i][j];
            }
        }
        return f;
    }
}