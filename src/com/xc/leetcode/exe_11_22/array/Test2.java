package com.xc.leetcode.exe_11_22.array;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class Test2 {
    public static void main(String[] args) {
        String[] array = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<String, List<String>> map = new HashMap<>();
        for (String s : array) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String newStr = new String(chars);
            List<String> strings = map.getOrDefault(newStr, new ArrayList<>());
            strings.add(s);
            map.put(newStr,strings);
        }
        Collection<List<String>> values = map.values();
        String s = Arrays.toString(values.toArray());
        System.out.println(s);
    }

}
