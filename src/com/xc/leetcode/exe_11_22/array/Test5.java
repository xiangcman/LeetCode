package com.xc.leetcode.exe_11_22.array;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构容器可以容纳最多的水。
 * <p>成的
 * 返回容器可以储存的最大水量。
 */
public class Test5 {
    public static void main(String[] args) {
        int[] ints = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int left = 0;
        int right = ints.length - 1;
        int maxValue = Integer.MIN_VALUE;
        while (left < right) {
            if (ints[left] < ints[right]) {
                int currentValue = (right - left) * ints[left];
                left++;
                maxValue = Math.max(maxValue, currentValue);
            }else{
                int currentValue = (right - left) * ints[right];
                right--;
                maxValue = Math.max(maxValue, currentValue);
            }
        }
        System.out.println("maxValue = " + maxValue);
    }
}
