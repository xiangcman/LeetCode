package com.xc.leetcode.exe_11_22.array;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * <p>
 * https://mp.weixin.qq.com/s?__biz=MzA3NTUwNzk0Mw==&mid=2729165257&idx=1&sn=5c47c37502da52120ede911cffb93b96&chksm=b83010418f479957a7ad05ae392f0b7c650df3b6d00e3c287c67a4e4f1e1dc6cda7a30290e06#rd
 */
public class Test11 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        reOrderArray(array);
        String s = Arrays.toString(array);
        System.out.println("s = " + s);
    }

    public static void reOrderArray(int[] nums) {
        //先算出奇数的个数,次个数作为偶数的开始索引
        int startOu = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num % 2 == 1) {
                startOu++;
            }
        }
        int[] newArray = new int[nums.length];
        System.arraycopy(nums, 0, newArray, 0, nums.length);
        int start = 0;
        for (int i : newArray) {
            if (i % 2 == 1) {
                nums[start] = i;
                start++;
            } else {
                nums[startOu] = i;
                startOu++;
            }
        }
    }

}
