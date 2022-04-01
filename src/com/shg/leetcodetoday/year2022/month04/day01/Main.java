package com.shg.leetcodetoday.year2022.month04.day01;

import java.util.*;

/**
 * @author: shg
 * @date 2022/4/1 4:39 下午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {0, 0, 4, -2, 2, -4, -4, -8};
        System.out.println(s.canReorderDoubled(arr));
    }
}

/**
 * 954. 二倍数对数组
 * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/array-of-doubled-pairs/
 */
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (map.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }

        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            list.add(key);
        }
        Collections.sort(list, (o1, o2) -> {
            return Math.abs(o1) - Math.abs(o2);
        });

        for (Integer num : list) {
            if (map.get(num) > map.getOrDefault(2 * num, 0)) {
                return false;
            }
            map.put(2 * num, map.getOrDefault(2 * num, 0) - map.get(num));
        }
        return true;
    }
}