package com.xc.leetcode.array;

import java.util.HashSet;
import java.util.Set;
@Deprecated
class Solution {
    public static void main(String[] args) {
        int i = longestConsecutive(new int[]{1, 2,4,3});
        System.out.println("i = " + i);
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {//明白了，这里防止到了2的时候又重新算一遍了
                int currentNum = num;
                System.out.println("currentNum = " + currentNum);
                int currentStreak = 1;
                //每次循环的时候，判断下一个连续的数存在不，如果存在就继续找下一个连续的数
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}