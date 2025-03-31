package com.xc.leetcode.exe_11_22.array;

import java.util.Arrays;

public class Test30 {
    public static void main(String[] args) {
        int fast = 1;
        int slow = 1;
        int[] array = new int[]{1, 1, 1, 2, 2, 2, 3, 3,4};
//        while (fast < array.length) {
//            if (array[fast] != array[slow]) {
//                array[slow] = array[fast];
//                slow++;
//            }
//            fast++;
//        }
//        String s = Arrays.toString(array);
//        System.out.println("s = " + s);
//        System.out.println("slow = " + slow);

        int i = removeDuplicates(array);
        System.out.println("i = " + i);
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        String s = Arrays.toString(nums);
        System.out.println("s = " + s);
        return slow;
    }

}
