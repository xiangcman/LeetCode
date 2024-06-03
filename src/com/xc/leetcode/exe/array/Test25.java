package com.xc.leetcode.exe.array;

import java.util.Arrays;

/**
 * 两个数组拼成一个新数组，并且新数组的顺序是按照升序排列
 */
public class Test25 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        String s = Arrays.toString(nums1);
        System.out.println("s = " + s);
    }

    /**
     *
     * @param nums1
     * @param m：数组num1前m个数字
     * @param nums2
     * @param n：数组num2前n个数字
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newArray = new int[nums1.length];
        System.arraycopy(nums1, 0, newArray, 0, nums1.length);
        int current = 0;
        int count = Math.max(m, n);
        int i = 0;
        int j = 0;
        while (current < m + n) {
            int a = 0;
            int b = 0;
            if (i <m) {
                a = newArray[i];
            }else{
                a=-1;
            }
            if (j <n) {
                b = nums2[j];
            }else{
                b=-1;
            }
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            if (a <= b) {
                if(a==-1){
                    nums1[current++] = b;
                    j++;
                }else {
                    nums1[current++] = a;
                    i++;
                }
            } else {
                if(b==-1){
                    nums1[current++] = a;
                    i++;
                }else {
                    nums1[current++] = b;
                    j++;
                }
            }
            System.out.println("i = " + i);
            System.out.println("j = " + j);
        }

    }
}
