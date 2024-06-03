package com.xc.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class TestLinekedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> integerStringLinkedHashMap = new LinkedHashMap<Integer, String>(16, 0.75f, true);

        integerStringLinkedHashMap.put(1, "1");
        integerStringLinkedHashMap.put(2, "2");
        integerStringLinkedHashMap.put(3, "3");
        integerStringLinkedHashMap.put(4, "4");
        integerStringLinkedHashMap.put(5, "5");
        integerStringLinkedHashMap.get(1);//事实证明把它放到尾结点了

        Set<Map.Entry<Integer, String>> entries = integerStringLinkedHashMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println("entry = " + entry);
        }
    }
}
