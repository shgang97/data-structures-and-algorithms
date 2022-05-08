package com.shg.dynamicprogramming.sequencedp.longestincreasingsubsequence;

/**
 * @author: shg
 * @date 2022/5/8 8:13 下午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0,1,0,3,2,3};
        int i = s.lengthOfLIS(nums);
        System.out.println(i);
    }
}

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] f = new int[len];
        int ans = 1;
        for (int i = 0; i < len; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && f[i] < f[j] + 1) {
                    f[i] = f[j] + 1;
                }
            }
            ans = Math.max(f[i], ans);
        }
        return ans;
    }
}