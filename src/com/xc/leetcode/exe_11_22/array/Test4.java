package com.xc.leetcode.exe_11_22.array;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class Test4 {
    public static void main(String[] args) {
        int[] ints = {0, 1, 0, 3, 12};
        int[] newArray = new int[ints.length];
        int index = 0;
        for (int anInt : ints) {
            if (anInt > 0) {
                newArray[index] = anInt;
                index++;
            }
        }
        for (int i = index; i < newArray.length; i++) {
            newArray[i] = 0;
        }
        System.arraycopy(newArray,0,ints,0,newArray.length);
        String s = Arrays.toString(ints);
        System.out.println("s = " + s);
    }
}
