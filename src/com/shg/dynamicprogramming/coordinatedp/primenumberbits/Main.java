package com.shg.dynamicprogramming.coordinatedp.primenumberbits;

/**
 * @author: shg
 * @date 2022/4/1 11:38 下午
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int bits = s.countPrimeSetBits(6, 15);
        System.out.println(bits);
    }
}

/**
 *
 * 762. 二进制表示中质数个计算置位
 * 给你两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。
 * 计算置位位数 就是二进制表示中 1 的个数。
 * 例如， 21 的二进制表示 10101 有 3 个计算置位。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/
 */
class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        int[] f = new int[right + 1];
        f[1] = 1;
        for (int i = 2; i <= right; i++) {
            f[i] = f[i >> 1] + (i & 1);
        }
        int[] primes = getPrimes(32);
        for (int i = left; i <= right; i++) {
            ans += (primes[f[i] - 1] == 0) ? 1 : 0;
        }
        return ans;
    }

    public int[] getPrimes(int n){
        int primes[] = new int[n];
        primes[0] = 1;
        double prescription = Math.sqrt(n);
        for (int i = 2; i <= prescription; i++) {
            for (int j = i*i; j <= n; j+=i) {
                primes[j-1] = 1;
            }
        }
        return primes;
    }

}