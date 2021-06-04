package com.xc.leetcode.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 选择排序的第一层循环表示第一个数，第二层循环表示第二个数
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 3, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 第一层遍历的时候始终是第一个数，第二层遍历的时候始终是第二个数
     *
     * @param a
     */
    private static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
