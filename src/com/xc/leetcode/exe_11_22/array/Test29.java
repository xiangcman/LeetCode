package com.xc.leetcode.exe_11_22.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 删除重复的数字，返回新数组
 */
public class Test29 {
    public static Integer[] remove(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            Integer count = map.getOrDefault(i, 0);
            count++;
            map.put(i, count);
        }
        List<Integer> newList = new ArrayList<>();
        for (int i : array) {
            if (map.get(i) == 1) {
                newList.add(i);
            }
        }
        return newList.toArray(new Integer[newList.size()]);
    }
}
