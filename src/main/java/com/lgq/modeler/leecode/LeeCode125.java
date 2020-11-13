package com.lgq.modeler.leecode;

/**
 * 125. 验证回文串(Java)
 *
 * @author lgq
 */
public class LeeCode125 {
    public static boolean isPalindrome(String str) {
        // 当字符串为空或者只有一个字符时，返回true
        if (str.length() == 0 || str.length() == 1) {
            return true;
        }

        //将字符串中的字母全部变成大写字母，方便比较判断
        String strCopy = str.toUpperCase();
        int start = 0, end = str.length() - 1;
        while (start < end) {
            //寻找字符串中左边的数字字符或字母
            while (start < end && !isLetterOrDigit(strCopy.charAt(start))) {
                start++;
            }
            //寻找字符串右边的数字字符或字母
            while (start < end && !isLetterOrDigit(strCopy.charAt(end))) {
                end--;
            }
            //若左右字符不相等时，返回false
            if ((start < end) && (strCopy.charAt(start) != strCopy.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * 判断该字符是否是数字字符或字母
     *
     * @param c
     * @return
     */
    private static boolean isLetterOrDigit(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        } else if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }


    public static boolean isPalindromeV2(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            while ((left < right) && (!Character.isLetterOrDigit(str.charAt(left)))) {
                left++;
            }
            while ((left < right) && (!Character.isLetterOrDigit(str.charAt(right)))) {
                right--;
            }
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
        System.out.println(isPalindromeV2(str));
    }
}
