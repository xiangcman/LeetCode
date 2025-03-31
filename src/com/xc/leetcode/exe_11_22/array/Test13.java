package com.xc.leetcode.exe_11_22.array;

import java.util.Arrays;

/**
 * 找出数组中超过一半的数字
 * <p>
 * 思路：先将数组拍好顺序，如果中间的数字的个数超过了数组一半的长度，那说明就是该数字
 */
public class Test13 {
    public int MoreThanHalfNum_Solution(int[] array) {
        Arrays.sort(array);
        int middle = array[array.length / 2];
        int count = 0;
        for (int i : array) {
            if (i == middle) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return middle;
        }
        return -1;
    }
}
