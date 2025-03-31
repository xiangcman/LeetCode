package com.xc.leetcode.exe.basic;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        int i = test.hashCode();
        System.out.println("test = " + test);
        System.out.println("i = " + i);//经过测试发现test的hashcode值是test对象内存地址（16进制）的10进制
    }
}
