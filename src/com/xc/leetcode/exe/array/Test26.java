package com.xc.leetcode.exe.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test26 {
    public static void main(String[] args) {
        String s = reverseWords("  hello world  ");
        System.out.println("s = " + s);
    }
    public static String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
//        List<String> wordList = Arrays.asList(s.split(" "));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
