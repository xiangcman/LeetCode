package com.xc.leetcode.exe.array;

import java.util.Arrays;

/**
 * 找出两数之和等于target
 */
public class Test27 {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 3, 4}, 6);
        String s = Arrays.toString(ints);
        System.out.println("s = " + s);
    }

    public static int[] twoSum(int[] numbers, int target) {
        // 利用二分法查找
        for (int i = 0; i < numbers.length; i++) {
            int other = target - numbers[i];
            int left = i + 1;//1
            int right = numbers.length - 1;//2
            while (left <= right) {
                int centerIndex = (left + right) / 2;
                if (other == numbers[centerIndex]) {
                    return new int[]{i + 1, centerIndex + 1};//返回两个数的索引
                } else if (numbers[centerIndex] > other) {
                    right = centerIndex - 1;
                } else if (numbers[centerIndex] < other) {
                    left = centerIndex + 1;
                }
            }
        }
        return new int[2];
    }
}
