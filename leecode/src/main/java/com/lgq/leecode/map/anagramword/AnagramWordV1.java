package com.lgq.leecode.map.anagramword;

import java.util.Arrays;

/**
 * @author lgq
 */
public class AnagramWordV1 {

    public static void main(String[] args) {
        String strA = "hello";
        String strB = "olleh";

        System.out.println("IsAnagram=" + isAnagramV2(strA, strB));
    }

    private static boolean isAnagramV1(String strA, String strB) {
        char[] arrStrA = strA.toCharArray();
        char[] arrStrB = strB.toCharArray();

        Arrays.sort(arrStrA);
        Arrays.sort(arrStrB);

        return Arrays.equals(arrStrA, arrStrB);
    }

    private static boolean isAnagramV2(String strA, String strB) {
        if (strA.length() != strB.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < strA.length(); i++) {
            counter[strA.charAt(i) - 'a']++;
            counter[strB.charAt(i) - 'a']--;
        }

        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
