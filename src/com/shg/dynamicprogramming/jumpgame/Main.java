package com.shg.dynamicprogramming.jumpgame;

import java.util.TreeMap;

/**
 * @author: shg
 * @date 2022/3/30 9:22 下午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,2,1,0,4};
        System.out.println(s.canJump(nums));
    }
}

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game/
 */
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] f = new boolean[n];

        f[0] = true;

        for (int i = 1; i < n; i++) {
            f[i] = false;
            for (int j = i - 1; j >= 0; j--) {
                if (f[j] && (i - j) <= nums[j]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n - 1];

    }
}