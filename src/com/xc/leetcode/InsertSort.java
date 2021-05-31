package com.xc.leetcode;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 3, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > temp) {//如果前面的数一直大于当前的值的话，则一直循环处理
                a[j + 1] = a[j];//把数组前面的一个值给当前的元素
                j--;
            }
            a[j + 1] = temp;
        }
    }
}
