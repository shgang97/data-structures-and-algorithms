package com.shg.dynamicprogramming.sequencedp.houserobber2;


import com.shg.utils.Randoms;

/**
 * @author: shg
 * @date 2022/4/2 7:50 下午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        Solution1 s1 = new Solution1();
        for (int i = 0; i < 10000; i++) {
            int[] arr = Randoms.getRandomArray(1000, 100);
            int res1 = s.rob(arr);
            int res2 = s1.rob(arr);
            System.out.println("res2 = " + res2);
            System.out.println("res1 = " + res1);
            if (res1 != res2) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[j] + ",");
                }
            }

        }
    }
}

/**
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii/
 */
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2),
                rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }

        int a = nums[lo];
        int b = Math.max(a, nums[lo + 1]);

        for (int i = 2; i <= hi - lo; i++) {
            int tmp = b;
            b = Math.max(a + nums[lo + i], b);
            a = tmp;
        }
        return b;
    }
}
class Solution1 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2),
                rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }
        int[] f = new int[hi - lo + 1];
        f[0] = nums[lo];
        f[1] = Math.max(f[0], nums[lo + 1]);

        for (int i = 2; i <= hi - lo; i++) {
            f[i] = Math.max(f[i - 2] + nums[i + lo], f[i - 1]);
        }
        return f[hi - lo];
    }
}