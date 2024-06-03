package com.xc.leetcode.exe.array;


import java.util.*;

/**
 * 删除重复的数字，返回新数组
 */
public class Test29 {
    public static void main(String[] args) {
        Integer[] remove = remove(new int[]{1, 1, 2, 3});
        String s = Arrays.toString(remove);
        System.out.println("s = " + s);
    }
    public static Integer[] remove(int[] array){
        Map<Integer,Integer> map=new HashMap<>();//key为当前数，value为出现的次数
        for (int i : array) {
            Integer count = map.getOrDefault(i, 0);
            map.put(i,++count);
        }
        List<Integer> result=new ArrayList<>();
        for (int i : array) {
            if(map.get(i)==1){
                result.add(i);//最后只要等于1次的数，剩下的不要
            }
        }
        return result.toArray(new Integer[result.size()]);

    }
}
