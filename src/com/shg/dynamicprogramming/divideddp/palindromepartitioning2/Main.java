package com.shg.dynamicprogramming.divideddp.palindromepartitioning2;

/**
 * @author: shg
 * @date 2022/5/12 8:48 下午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.minCut("abbbaddkkgajgadgjaaaaddddbbd");
        System.out.println(i);

    }
}

/**
 * 132. 分割回文串 II
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * <p>
 * 返回符合要求的 最少分割次数 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/palindrome-partitioning-ii/
 */
class Solution {
    public int minCut(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        boolean[][] isPalindrome = new boolean[len][len];

        for (int i = 0; i < isPalindrome.length; i++) {
            for (int j = 0; j < isPalindrome[i].length; j++) {
                isPalindrome[i][j] = false;
            }
        }
        for (int t = 0; t < len; t++) {
            int i = t, j = t;
            while (i >= 0 && j < len && chars[i] == chars[j]) {
                isPalindrome[i][j] = true;
                i--;
                j++;
            }
        }
        for (int t = 0; t < len; t++) {
            int i = t, j = t + 1;
            while (i >= 0 && j < len && chars[i] == chars[j]) {
                isPalindrome[i][j] = true;
                i--;
                j++;
            }
        }

        int[] f = new int[len + 1];
        f[0] = 0;
        for (int i = 1; i < f.length; i++) {
            f[i] = i;
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[len] - 1;
    }

}