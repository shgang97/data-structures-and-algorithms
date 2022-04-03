package com.shg.leetcodetoday.year2022.month04.day2;

/**
 * @author: shg
 * @date 2022/4/3 10:36 下午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[] chars = {'a', 'd', 'f', 'k'};
        System.out.println(s.nextGreatestLetter(chars, 'b'));
    }
}

/**
 * 744. 寻找比目标字母大的最小字母
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * 在比较时，字母是依序循环出现的。举个例子：
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 */
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if (target >= letters[letters.length - 1]) {
            return letters[0];
        }
        int i = 0, j = letters.length - 1;
        while (i < j) {
            int mid = i + ((j - i) >> 1);
            char curr = letters[mid];
            if (target < curr) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return letters[i];
    }
}