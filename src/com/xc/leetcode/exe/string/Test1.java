package com.xc.leetcode.exe.string;

public class Test1 {
    public static void main(String[] args) {
        int i = string2Int("123");
        System.out.println("i = " + i);
    }

    public static int string2Int(String input) {
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
//            int m=c;
//            System.out.println("m = " + m);
            //得到char的10进制数
            int digit = Character.digit(c, 10);
            int wei = 1;
            //每一位的数其实是：当前数字*10^n
            for (int j = 0; j < input.length() - 1 - i; j++) {
                wei *= 10;
            }
            result += digit * wei;
        }
        return result;
    }
}
