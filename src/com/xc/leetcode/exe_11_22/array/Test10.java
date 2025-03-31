package com.xc.leetcode.exe_11_22.array;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
 */
public class Test10 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 1, 2, 2, 3};
        int length = getLength(array);
        System.out.println("length = " + length);

    }

    private static int getLength(int[] array) {
        if (array.length <= 2) {
            return array.length;
        }
        int slow = 2;
        int fast = 2;
        while (fast < array.length) {
            if (array[slow - 2] != array[fast]) {
                array[slow] = array[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
