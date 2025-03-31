package com.xc.leetcode.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        //|.*/R\.*
        boolean result = Pattern.matches(".*/R\\$.*", "com/xc/lib/R$color");
        System.out.println("result = " + result);


        boolean result1 = Pattern.matches(".*/R\\.*", "com/xc/lib/R...");
        System.out.println("result1 = " + result1);

        boolean result2 = Pattern.matches(".*/R\\$.*|.*/R\\.*", "com/xc/lib/R...");
        System.out.println("result2 = " + result2);


        Pattern pattern = Pattern.compile("(#[^#]*[^#\\s]+[^#]*#)");
        Matcher matcher = pattern.matcher("#key_mmkv_migrate_version# ");
        boolean b = matcher.find();
        System.out.println("b = " + b);
    }
}
