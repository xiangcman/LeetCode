package com.xc.leetcode.exe_11_22.array;

import java.util.Arrays;

/**
 * 两个数组拼成一个新数组，并且新数组的顺序是按照升序排列
 */
public class Test25 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int[] merge = merge(nums1, 3, nums2, 3);
        String s = Arrays.toString(merge);
        System.out.println("s=" + s);
    }

    /**
     * @param nums1
     * @param m：数组num1前m个数字
     * @param nums2
     * @param n：数组num2前n个数字
     */
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newArray = new int[m + n];
        int current = 0;
        int a = 0;
        int b = 0;
        //先把两者没超过范围的数据加入到新的数组中
        while (a < m && a < nums1.length && b < n && b < nums2.length) {
            int value1 = nums1[a];
            int value2 = nums2[b];
            if (value1 <= value2) {
                newArray[current] = value1;
                a++;
            } else {
                newArray[current] = value2;
                b++;
            }
            current++;
        }
        //然后把两个剩余的数组数据给加入到新数组中
        if (a < m && a < nums1.length) {
            int min = Math.min(m, nums1.length);
            for (int i = a; i < min; i++) {
                newArray[current] = nums1[i];
                current++;
            }
        }
        if (b < n && b < nums2.length) {
            int min = Math.min(n, nums2.length);
            for (int i = b; i < min; i++) {
                newArray[current] = nums2[i];
                current++;
            }
        }
        return newArray;
    }
}
