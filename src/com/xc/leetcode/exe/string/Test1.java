package com.xc.leetcode.exe.string;

/**
 * string转成int
 */
public class Test1 {
    public static void main(String[] args) {
        int i = string2Int("745");
        System.out.println("i = " + i);
    }

    public static int string2Int(String input) {
        int result = 0;
        int length = input.length();
        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            //得到char的10进制数
            int digit = c - 48;
            System.out.println("digit = " + digit);
            result = result * 10 + digit;
        }
        return result;
        //1
        //1*10+2
        //(1*10+2)*10+3=
    }
}
