package com.shg.dynamicprogramming.sequencedp.russiandollenvelopes;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: shg
 * @date 2022/5/8 8:34 下午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] envelopes = {{1,2},{2,3},{1,4},{1,1}};
        int i = s.maxEnvelopes(envelopes);
        System.out.println(i);

    }
}

/**
 * 354. 俄罗斯套娃信封问题
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 注意：不允许旋转信封。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes/
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes,(o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        int len = envelopes.length;
        int[] f = new int[len];
        int ans = 1;

        for (int i = 0; i < len; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1] && f[i] < f[j] + 1) {
                    f[i] = f[j] + 1;
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}