package com.xc.leetcode.exe_11_22.array;

import sun.misc.LRUCache;

import java.util.Arrays;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * <p>
 * https://leetcode.cn/problems/first-missing-positive/?envType=study-plan-v2&envId=top-100-liked
 */
public class Test23 {

    public static void main(String[] args) {
        int i = firstMissingPositive(new int[]{3, 4, -1, 1, 9, -5});
        System.out.println("i = " + i);
    }

    /**
     * 这个题的思路就是缺失的数一定是在1-N之间，N是数组的长度
     * 第一步：将数组中小于0的数给附上N+1
     * 第二步：将数组中小于N的数，给他标记上为负数，标记的思想就是：数组中的值作为下标，然后给该下标的数置为负数
     * 第三步：所以不缺失的数所对应的数组中的数都是负数，所以只要找出第一个出现正数的数就是缺失的最小正整数
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num <= 0) {
                nums[i] = length + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            //在比较的时候，需要取值的绝对值，因为下面会给对应的索引上的值给置为负数了，所以此处需要还原下它的值
            int num = Math.abs(nums[i]);
            if (num < length) {
                //小于length的值对应的索引值给它置为负数
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
            String s = Arrays.toString(nums);
            System.out.println("s = " + s);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0 && num < length) {
                return i + 1;
            }
        }
        return length + 1;
    }
}
