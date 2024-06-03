package com.xc.leetcode.sort;


import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] a = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] a = new int[]{2, 8, 6, 4, 9, 3, 5, 1};
//        int[] a = new int[]{2, 8, 6, 4, 9, 3, 5, 1};
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int L, int R) {
        int pivot = a[(L + R) / 2];//取中间的数作为基准值
        int i = L;
        int j = R;
        while (i <= j) {
            while (a[i] < pivot) {//从左边找比基准值大的数，如果大于则不找了
                i++;
            }
            while (a[j] > pivot) {//找出右边比基准值小的数，
                j--;
            }
            //此时找到了左边比基准值大的值，找到了右边比基准值小的值，找到后进行交换
            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
            System.out.println(Arrays.toString(a));
            System.out.println("i:" + i);
            System.out.println("j:" + j);
            System.out.println("===========");
        }
        System.out.println("-------------");
        System.out.println(Arrays.toString(a));
        System.out.println("i:" + i);
        System.out.println("j:" + j);
        //上面的一轮比较后，保证了基准值左边的数都是比基准值要小，基准值游币拿的数都是比基准值要大
        //然后基准值右边的数进行递归
        if (i < R) {
            sort(a, i, R);
        }
        //基准值左边的值进行比较
        if (j > L) {
            sort(a, L, j);
        }
    }
}
