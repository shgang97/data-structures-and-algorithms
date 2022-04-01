package com.shg.dynamicprogramming.coordinatedp.longestincreasingcontinuoussubsequence;

/**
 * @author: shg
 * @date 2022/4/1 9:34 下午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {6,5,4,2,1,3,5,3,9,10,22, 11, 15,16,17,18,19};
        System.out.println(s.longestIncreasingContinuousSubsequence(arr));
    }
}

/**
 * 397 · 最长上升连续子序列
 * 题目题解笔记讨论排名
 * 描述
 * 给定一个整数数组（下标从 0 到 n-1， n 表示整个数组的规模），请找出该数组中的最长上升连续子序列。（最长上升连续子序列可以定义为从右到左或从左到右的序列。）
 * 来源：lintcode
 * 链接：https://www.lintcode.com/problem/397/
 */
class Solution {
    public int longestIncreasingContinuousSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0)
            return 0;
        int res1 = lcs(nums);
        reverse(nums);
        int res2 = lcs(nums);
        reverse(nums);
        return Math.max(res1, res2);
    }

    public int lcs(int[] nums) {
        int preLength = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                preLength += 1;
            } else {
                preLength = 1;
            }
            max = Math.max(max, preLength);
        }
        return max;
    }
    public int lcs1(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = 1;
        int max = 1;
        for (int i = 1; i < f.length; i++) {
            f[i] = 1;
            if (nums[i] > nums[i - 1]) {
                f[i] += f[i - 1];
            }
            max = Math.max(max, f[i]);
        }
        return max;
    }

    public void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

}