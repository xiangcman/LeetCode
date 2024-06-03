package com.xc.leetcode.sort;


import java.util.Arrays;

/**
 * 冒泡排序
 * 冒泡排序的第一层循环表示每一轮需要遍历的次数，第二轮才是需要比较的数
 */
public class MaoSort {
    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 3, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
                System.out.println(Arrays.toString(a));
                System.out.println("====");
            }
        }
    }
}
