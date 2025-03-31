package com.xc.leetcode.exe_11_22.array;


import java.util.HashSet;
import java.util.Set;

/**
 * 剑指Offer（五十）-- 数组中重复的数字
 * <p>
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中第一个重复的数字。例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是第一个重复的数字2。
 * 没有重复的数字返回-1。
 * https://mp.weixin.qq.com/s?__biz=MzA3NTUwNzk0Mw==&mid=2729167008&idx=1&sn=d9f47900ff5231b7127102240610f793&chksm=b83019288f47903e3453819824d5fde0dae0361ce77ba5e1fb296b7ffc4f2b669f2fed1e0f4e#rd
 * <p>
 * 输入
 * <p>
 * [2,3,1,0,2,5,3]
 * <p>
 * 返回值
 * <p>
 * 2
 */
public class Test18 {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 0, 2, 5, 3};
        int duplicate = duplicate(array);
        int i = duplicate1(array);
        System.out.println("duplicate = " + duplicate);
        System.out.println("duplicate1 = " + i);
    }

    public static int duplicate(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (set.contains(number)) {
                return number;
            }
            set.add(number);
        }
        return -1;
    }

    /**
     * 利用一个单独的数组，来表示每一个数的次数，如果发现已经有等于1的次数的值，则将该值返回
     *
     * @param numbers
     * @return
     */
    public static int duplicate1(int[] numbers) {
        int[] newArray = new int[numbers.length];
        for (int number : numbers) {
            if (newArray[number] == 1) {
                return number;
            }
            newArray[number] = 1;
        }
        return -1;
    }
}
