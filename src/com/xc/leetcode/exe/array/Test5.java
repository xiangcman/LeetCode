package com.xc.leetcode.exe.array;

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
        System.out.println("result = " + maxArea(ints));
    }

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            //如果左边比右边小则往左边右边移动，那么就左边的坐标需要++了
            if (height[i] < height[j]) {
                max = Math.max(max, (j - i) * height[i]);//高度以矮的边为准
                i++;
            } else {
                //否则右边往左边移动，如果往左边移动，需要右边的坐标--
                max = Math.max(max, (j - i) * height[j]);
                j--;
            }
        }
        return max;
    }
}
