package com.shg.dynamicprogramming.coordinatedp.uniquepaths2;

/**
 * @author: shg
 * @date 2022/3/31 7:18 下午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr = {
                {0, 0},
                {1, 1},
                {0, 0}
        };
        System.out.println(s.uniquePathsWithObstacles(arr));
    }
}

/**
 * 来源：力扣（LeetCode）
 * 链接：
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m][n];

        if (obstacleGrid[0][0] == 1) return 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    f[i][j] = 0;
                else {
                    if (i == 0 && j == 0) {
                        f[i][j] = 1;
                    } else {
                        f[i][j] = 0;
                        if (i >= 1)
                            f[i][j] += f[i - 1][j];
                        if (j >= 1)
                            f[i][j] += f[i][j - 1];
                    }
                }

            }
        }
        return f[m - 1][n - 1];
    }
}