package com.xc.leetcode;

import java.util.Arrays;

/*
小米一面算法题：
hello world得到world hello
思路：整体翻转char数组，然后每一个小的单词进行翻转
 */
public class StringTest {
    public static void main(String[] args) {
//        char[] a = {'H', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'}; // Hello world
        char[] a = {'a', 'r', 'e',' ', 'y', 'o', 'u',' ', 'o', 'k'}; // Hello world
        revert(a, 0, a.length);
//        String s1 = Arrays.toString(a);
//        System.out.println("s1 = " + s1);
        int start = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == ' ') {
                System.out.println("i = " + i);
                revert(a, start, i);
                start = i + 1;
            }
        }
        revert(a, start, a.length);
        String s = Arrays.toString(a);
        System.out.println("s = " + s);
    }

    public static void revert(char[] input, int start, int end) {
        for (int e = start; e < (start + end) / 2; e++) {
            char temp = input[e];
            input[e] = input[start + end - 1 - e];
            input[start + end - 1 - e] = temp;
        }
    }


}
