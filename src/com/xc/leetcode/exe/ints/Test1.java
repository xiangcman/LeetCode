package com.xc.leetcode.exe.ints;

public class Test1 {
    public static void main(String[] args) {
        Integer integer1=1;//因为此处会进行装箱，对应的方法是valueof，当数值在-128到127的时候，会从integercache中取integer对象，否则直接new integer
        Integer integer2=1;
        System.out.println(integer1==integer2);

        Integer integer3=128;
        Integer integer4=128;
        System.out.println(integer3==integer4);
    }
}
