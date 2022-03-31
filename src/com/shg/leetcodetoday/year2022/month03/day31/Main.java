package com.shg.leetcodetoday.year2022.month03.day31;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: shg
 * @date 2022/3/31 11:07 上午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> list = s.selfDividingNumbers(47, 85);
        for (Integer num : list) {
            System.out.println(num);
        }
    }
}

/**
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/self-dividing-numbers/
 */
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumbers(i))
                list.add(i);
        }
        return list;
    }

    public boolean isSelfDividingNumbers(int num) {
        int n = num;
        while (n > 0) {
            int tail = n % 10;
            if (tail == 0 || num % tail != 0) return false;
            n /= 10;
        }
        return true;
    }
}