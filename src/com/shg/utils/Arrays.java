package com.shg.utils;

/**
 * @author: shg
 * @create: 2022-04-03 8:08 下午
 */
public class Arrays {
    public static void printArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("argument arr must be not null");
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.println(arr[i]);
            }
        }
    }
}
