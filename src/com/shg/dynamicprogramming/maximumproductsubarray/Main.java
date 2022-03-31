package com.shg.dynamicprogramming.maximumproductsubarray;

import javax.sql.rowset.FilteredRowSet;

/**
 * @author: shg
 * @date 2022/3/31 12:42 下午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {-2,0,-1, 5, -3};
        System.out.println(s.maxProduct(arr));
    }
}

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32-位 整数。
 * 子数组 是数组的连续子序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray/
 */
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int preMax = nums[0];
        int preMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            preMax = Math.max(nums[i], Math.max(nums[i] * preMax, nums[i] * preMin));
            preMax = Math.min(nums[i], Math.max(nums[i] * preMax, nums[i] * preMin));

        }
        return ans;
    }
}