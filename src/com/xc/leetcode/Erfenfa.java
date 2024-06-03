package com.xc.leetcode;

/**
 * 二分法查找
 */
public class Erfenfa {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        System.out.println("find:" + find(a, 0));
    }

    private static int find(int[] a, int find) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {//当左边的起点和右边的起点相等的时候就不比较了
            int temp = (left + right) / 2;
            int pivot = a[temp];
            if (find < pivot) {//如果要找的数比中间数要小，则在左侧找
                right = temp - 1;
            } else if (find > pivot) {
                left = temp + 1;
            } else {
                return temp;
            }
        }
        return -1;
    }
}
