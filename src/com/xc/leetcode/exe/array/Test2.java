package com.xc.leetcode.exe.array;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println("result = " + Arrays.toString(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).toArray()));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            //需要排序，排序完后异位词是相同的了，所以通过map就能查询到对应的list
            Arrays.sort(chars);
            String s = new String(chars);
            if (map.containsKey(s)) {
                List<String> stringList = map.get(s);
                stringList.add(str);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                map.put(s, stringList);
            }
        }
        return new ArrayList<>(map.values());
    }
}
