package com.lgq.modeler.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lgq
 * https://blog.csdn.net/weixin_43969686/article/details/104347312
 * https://www.zhihu.com/column/c_1248350897589673984
 */
public class LeeCode17 {
    private static Map<Character, String> map = new HashMap<>();
    private static List<String> ans = new ArrayList<>();

    private static void dsf(String digits, int index, String path) {
        // 结束条件（遍历到底，记录结果）
        if (index == digits.length()) {
            ans.add(path);
            return;
        }

        // s为选择列表
        String s = map.get(digits.charAt(index));
        for (int i = 0; i < s.length(); i++) {
            path += s.charAt(i);
            dsf(digits, index + 1, path);
            path = path.substring(0, path.length() - 1);
        }
    }

    public static List<String> letterCombination(String digits) {
        if (digits.length() == 0) {
            return ans;
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        dsf(digits, 0, "");
        return ans;
    }

    public static void main(String[] args) {
        String str = "23";
        List<String> list = letterCombination(str);
        for (String item : list) {
           System.out.println(item);
        }
    }
}
