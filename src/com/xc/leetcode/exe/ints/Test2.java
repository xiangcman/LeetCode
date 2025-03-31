package com.xc.leetcode.exe.ints;

/**
 * 整数反转
 */
public class Test2 {
    public static void main(String[] args) {
        int value = Integer.MAX_VALUE / 10;
        int value1 = Integer.MIN_VALUE / 10;
        System.out.println("value = " + value);
        System.out.println("value1 = " + value1);
        int reverse = reverse(1147483649);
        System.out.println("reverse = " + reverse);
    }

    public static int reverse(int x) {
        int result = 0;
        int value = Integer.MAX_VALUE / 10;
        int last = Integer.MAX_VALUE % 10;
        int value1 = Integer.MIN_VALUE / 10;
        int last1 = Integer.MIN_VALUE % 10;
        System.out.println("value = " + value);
        System.out.println("last = " + last);
        System.out.println("value1 = " + value1);
        System.out.println("last1 = " + last1);
        while (x != 0) {
            int current = x % 10;
            if (result > value || (result == value && current > last)) {
                return 0;
            }
            if (result < value1 || (result == value1 && current < last1)) {
                return 0;
            }
            result = result * 10 + current;
            x = x / 10;
        }
        return result;
    }
}
