package com.xc.leetcode.fan;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws NoSuchFieldException {
        Foot foot = new Foot();
//        foot.setApple(new RedApple());
        Field apple = foot.getClass().getDeclaredField("apple");
        Class<?> type = apple.getType();
//        String name = foot.apple.getClass().getName();
        System.out.println("type = " + type);

//        List list=new ArrayList<String>();
//        list.add(new Object());
//        Object o = list.get(0);
    }
}
