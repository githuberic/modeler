package com.lgq.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * from https://github.com/azl397985856/leetcode/blob/master/problems/3.longest-substring-without-repeating-characters.md
 *
 * @author lgq
 */
public class LeeCode3 {
    public static int lengthOfLongestSubString(String str) {
        int res = 0;
        if (str.length() == 0) {
            return res;
        }

        // 创建HashMap，用来保存字符与位置之间的对应关系
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        // 初始化左指针和右指针，并遍历字符串
        for (int left = 0, right = 0; right < str.length(); right++) {
            // 确定左指针的位置
            if (map.containsKey(str.charAt(right))) {
                // 确定左指针的位置
                left = Math.max(left, map.get(str.charAt(right)) + 1);
            }
            // 对于第一次出现的字符，保存该字符的位置；对于多次出现的字符，更新该字符出现的位置
            map.put(str.charAt(right), right);
            // 更新窗口的大小，保存最大的窗口大小
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubString(str));
    }
}
