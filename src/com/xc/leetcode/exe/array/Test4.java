package com.xc.leetcode.exe.array;

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
        moveZeroes(ints);
        System.out.println("result = " + Arrays.toString(ints));
    }

    public static void moveZeroes(int[] nums) {
        //思路是采用一个新的数组出来
        int[] news = new int[nums.length];
        int count = 0;
        for (int num : nums) {
            if (num > 0) {//然后将大于0的元素放到新数组里面，并且下标从0开始算起
                news[count] = num;
                count++;
            }
        }
        //然后把剩余的给置为0，这样就得到了前面是大于0的数，后面都是0
        for (int i = count; i < nums.length; i++) {
            news[i] = 0;
        }
        System.arraycopy(news, 0, nums, 0, nums.length);
    }
}
