package com.xc.leetcode.exe.array;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * <p>
 * https://mp.weixin.qq.com/s?__biz=MzA3NTUwNzk0Mw==&mid=2729165257&idx=1&sn=5c47c37502da52120ede911cffb93b96&chksm=b83010418f479957a7ad05ae392f0b7c650df3b6d00e3c287c67a4e4f1e1dc6cda7a30290e06#rd
 */
public class Test11 {
    public void reOrderArray(int[] nums) {
        //先把奇数的个数找到，然后就知道偶数的起始位置了
        int startOu = 0;
        for (int num : nums) {
            if (num % 2 == 1) {
                startOu++;
            }
        }
        int[] news = nums;
        int start = 0;
        for (int i : news) {
            if (i % 2 == 1) {
                nums[start] = i;//把奇数都放前面
                start++;
            } else {
                nums[startOu] = i;//把偶数都放后面
                startOu++;
            }
        }
    }
}
