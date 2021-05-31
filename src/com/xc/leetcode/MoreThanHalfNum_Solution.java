package com.xc.leetcode;

import java.util.Arrays;

/**
 * * 计算数组里面超过一半的数字，如果没有这样的数字，则返回0
 * * 先把数组排序，如果有超过一半的数字，则中间位置的数字一定是该数字
 * * 然后通过出现该数的次数来判断是否超过一半
 */
public class MoreThanHalfNum_Solution {
    public static int MoreThanHalfNum_Solution(int[] array) {
        //先排序
        Arrays.sort(array);
        //找出中间的数
        int temp = array[array.length / 2];
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            //如果遍历当前的数是中间的数则加一次
            if (temp == array[i]) {
                num++;
            }
        }
        //最后发现num比长度的2分之一还要小，说明该数据没有过半
        if (num <= array.length / 2) {
            temp = 0;
        }
        return temp;
    }
}
