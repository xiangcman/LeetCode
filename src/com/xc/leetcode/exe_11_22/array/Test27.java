package com.xc.leetcode.exe_11_22.array;

import java.util.Arrays;

/**
 * 在一个有序数组中找出两数之和等于指定的数
 */
public class Test27 {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 3, 4}, 6);
        String s = Arrays.toString(ints);
        System.out.println("s = " + s);
    }

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int other = target - numbers[i];
            int left = i + 1;
            int right = numbers.length - 1;
            while (left <= right) {
                int centerIndex = (left + right) / 2;
                int centerValue = numbers[centerIndex];
                if (other == centerValue) {
                    return new int[]{i, centerIndex};
                } else if (other > centerValue) {
                    left = centerIndex + 1;
                } else {
                    right = centerIndex - 1;
                }
            }
        }
        return new int[2];
    }

}
