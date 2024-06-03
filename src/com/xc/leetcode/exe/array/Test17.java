package com.xc.leetcode.exe.array;

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
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        //key：表示哪个数字，value：表示数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            Integer count = map.get(i);
            if (count == null) {
                map.put(i, 1);
            } else {
                map.put(i, count + 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                if (count == 0) {
                    num1[0] = entry.getKey();
                    count++;
                } else {
                    num2[0] = entry.getKey();
                    break;
                }

            }
        }

    }
}
