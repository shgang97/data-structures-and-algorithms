package com.shg.dynamicprogramming.divideddp.decodeways;

/**
 * @author: shg
 * @date 2022/3/31 8:35 下午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDecodings("1273123"));
    }
}

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways/
 */
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.startsWith("0")) {
            return 0;
        }

        int n = s.length();
        char[] chars = s.toCharArray();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i < f.length; i++) {
            f[i] = 0;
            int curr = chars[i - 1] - '0';
            if (1 <= curr && curr <= 9) {
                f[i] += f[i - 1];
            }
            if (i >= 2) {
                curr = (chars[i - 2] - '0') * 10 + chars[i - 1] - '0';
                if (10 <= curr && curr <= 26) {
                    f[i] += f[i - 2];
                }
            }
        }
        return f[n];

    }
}