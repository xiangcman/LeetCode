package com.xc.leetcode.exe_11_22.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 剑指Offer（四十）-- 数组中只出现一次的数字
 * https://mp.weixin.qq.com/s?__biz=MzA3NTUwNzk0Mw==&mid=2729166724&idx=1&sn=fa3cfebb1e1ce156047eeb342a1f3edd&chksm=b830160c8f479f1acec74356fa217bc3017103928f4e3a3d7dc50643ba29412ec76b8d30aa88#rd
 * <p>
 * 输入
 * <p>
 * [92,3,43,54,92,43,2,2,54,1]
 * <p>
 * 输出
 * <p>
 * 3,1
 */
public class Test17 {
    public static void main(String[] args) {
        int[] array = new int[]{92,3,43,54,92,43,2,2,54,1};
        int[] num1 =new int[1];
        int[] num2 =new int[1];
        FindNumsAppearOnce(array,num1,num2);
        String s1 = Arrays.toString(num1);
        String s2 = Arrays.toString(num2);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }
    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        //map的key存的是哪个数，value是存的数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            Integer count = map.getOrDefault(i, 0);
            count++;
            map.put(i, count);
        }
        int count = 0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer key = entry.getValue();
            if (key == 1) {
                if (count == 0) {
                    num1[0] = entry.getKey();
                    count++;
                }else{
                    num2[0] = entry.getKey();
//                    count++;
                    break;
                }
            }
        }
    }
}
