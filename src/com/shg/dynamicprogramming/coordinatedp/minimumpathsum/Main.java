package com.shg.dynamicprogramming.coordinatedp.minimumpathsum;

/**
 * @author: shg
 * @date 2022/4/1 10:08 下午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println(s.minPathSum(grid));

    }
}

/**
 * 来源：力扣（LeetCode）
 * 链接：
 */
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            throw new IllegalArgumentException("inputs are not required");
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] f = new int[n];

        f[0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            f[j] = f[j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    f[j] += grid[i][j];
                } else {
                    f[j] = grid[i][j] + Math.min(f[j], f[j - 1]);
                }
            }
        }
        return f[n - 1];
    }

    public int minPathSum1(int[][] grid) {
        if (grid == null || grid.length == 0) {
            throw new IllegalArgumentException("inputs are not required");
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[2][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = grid[i][j];
                if (i == 0 || j == 0) {
                    if (j != 0) {
                        f[i][j] += f[i][j - 1];
                    } else if (i != 0) {
                        f[i][j] += f[i - 1][j];
                    }
                } else {
                    f[i][j] += Math.min(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[m - 1][n - 1];
    }
}