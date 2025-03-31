package com.xc.leetcode.exe.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和等于target
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println("twoSum = " + Arrays.toString(twoSum2(new int[]{1, 2, 3, 4, 5}, 3)));
    }

    /**
     * 双层迭代
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {//索引i的数每次先固定住，然后依次遍历j
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return null;
    }

    /**
     * 采用存储器
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        //key存的是数组中对应的值，value存的是数组中数对应的索引
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
