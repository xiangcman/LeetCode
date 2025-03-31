package com.xc.leetcode.exe_11_22.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test26 {
    public static void main(String[] args) {

    }

    public static String reverseWords(String s) {
        String trim = s.trim();
        List<String> strings = Arrays.asList(trim.split("\\s"));
        Collections.reverse(strings);
        String join = String.join(" ", strings);
        return join;
    }
}
