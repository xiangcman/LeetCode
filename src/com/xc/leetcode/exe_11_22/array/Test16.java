package com.xc.leetcode.exe_11_22.array;

/**
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n).
 * <p>
 * 输入的数组为{1,-2,3,10,—4,7,2,一5}，和最大的子数组为{3,10,一4,7,2}，因此输出为该子数组的和 18。
 * <p>
 * 采用o(n)的解法，一层遍历
 * <p>
 * https://mp.weixin.qq.com/s?__biz=MzA3NTUwNzk0Mw==&mid=2729166245&idx=1&sn=c60e20ec1b8d3159f927843b95ffc6e8&chksm=b830142d8f479d3bc5971b00f08f7c7a2ee61c7eb1f63fa0ff1d98e442ef13d2c433c598c346#rd
 */
public class Test16 {
    public static void main(String[] args) {
        int[] array = new int[]{1,-2,3,10,-4,7,2,-5};
        int i = FindGreatestSumOfSubArray(array);
        System.out.println("i = " + i);
    }
    //采用动态规划的方式求和
    public static int FindGreatestSumOfSubArray(int[] array) {
        int currentMax=array[0];
        int maxValue=array[0];

        for (int i = 1; i < array.length; i++) {
            currentMax  = Math.max(currentMax+array[i],array[i]);
            maxValue = Math.max(maxValue,currentMax);
        }
        return maxValue;

    }
}
