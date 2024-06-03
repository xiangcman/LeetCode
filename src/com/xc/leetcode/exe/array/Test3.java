package com.xc.leetcode.exe.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class Test3 {
    public static void main(String[] args) {
        int i = longestConsecutive(new int[]{100, 4, 200, 1, 3});
        System.out.println("i = " + i);
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();
        for (int num : nums) {
            integerSet.add(num);
        }
        int result = 1;
        for (int num : nums) {
            if (!integerSet.contains(num - 1)) {
                int current = num;
                int currentStack = 1;
                while (integerSet.contains(current + 1)) {
                    currentStack++;
                    current++;
                    result = Math.max(result, currentStack);
                }
            }
        }
        return result;
    }
}
