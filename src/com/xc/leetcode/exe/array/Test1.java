package com.xc.leetcode.exe.array;

import java.util.Arrays;

/**
 * 两数之和等于target
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println("twoSum = " + Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {//索引i的数每次先固定住，然后依次遍历j
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return null;
    }
}
