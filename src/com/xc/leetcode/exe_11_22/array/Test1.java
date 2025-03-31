package com.xc.leetcode.exe_11_22.array;

import java.util.Arrays;

/**
 * 奇数位于数组的前半部分
 */
public class Test1 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        //思想就是先找出奇数的个数，该个数作为偶数的起始下标
        int startOu = 0;
        for (int i : array) {
            if (i % 2 == 1) {
                startOu++;
            }
        }
        int[] newArray = Arrays.copyOf(array,array.length);
        int start = 0;
        for (int i : newArray) {
            if (i % 2 != 0) {
                array[start] = i;
                start++;
            } else {
                array[startOu] = i;
                startOu++;
            }
        }
    }
}
