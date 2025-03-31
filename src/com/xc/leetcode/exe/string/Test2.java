package com.xc.leetcode.exe.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class Test2 {
    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("pwwkew");
        System.out.println("result = " + result);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> characters = new HashSet<>();
        int length = s.length();
        int currentIndex = -1;
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                characters.remove(s.charAt(i - 1));
            }
            //这里每层遍历的起始位置选择了前一轮遍历的终止位置，因为set集合中保留了之前不重复的数
            while (currentIndex + 1 < length && !characters.contains(s.charAt(currentIndex + 1))) {
                characters.add(s.charAt(currentIndex + 1));
                currentIndex++;
            }
            result = Math.max(result, currentIndex - i + 1);
        }
        return result;
    }
}
