package com.shg.util;

import java.util.Random;

/**
 * @author: shg
 * @create: 2022-03-31 7:34 下午
 */
public class Randoms {
    public static int getRandomInt(int limit) {
        return  (int) (Math.random() * limit) + 1;
    }

    public static int[] getRandomArray(int limit, int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getRandomInt(limit);
        }
        return arr;
    }
}
