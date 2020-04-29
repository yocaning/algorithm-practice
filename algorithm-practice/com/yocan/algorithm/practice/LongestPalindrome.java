package com.yocan.algorithm.practice;

import org.springframework.util.Assert;

/**
 * 最大回文子串
 * 中心拓展法
 * 思路：
 * 1. 穷举可以作为中心的点
 * 2. 向外拓展获取回文长度
 * 3. 取最大回文
 */
public class LongestPalindrome {
    private static String findLongestPalindrome(String str) {
        if (str.length() == 0 || str == "") {
            return "";
        }
        //字符串长度
        int length = str.length();
        //记录回文长度
        int strLength = 0;
        int start=0,end =0;
        for (int i = 0; i < length; i++) {
            int len1 = expandStr(str, length, i, i);
            int len2 = expandStr(str, length, i, i + 1);
            int bestLen = len1 > len2 ? len1 : len2;
            //此处可能出现多个回文长度一样，暂不考虑，以先发现的为准
            if (bestLen >strLength){
                //由于单双数的不同特性，所以利用该方法获取首尾
                 start =i-(bestLen-1)/2;
                 end =i+(bestLen)/2;
                strLength =bestLen;
            }
        }
        //substring方法是前闭后开区间
        return str.substring(start,end+1);

    }

    private static int expandStr(String str, int length, int left, int right) {
        while (left >= 0 && right < length && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        //自我测试
        String str =findLongestPalindrome("dddd");
        System.out.println(str.equals("dddd"));
        /**
         * 测试用例1
         * "cccbabddf"
         * ccc/bab
         */
        String str1 =findLongestPalindrome("cccbabddf");
        System.out.println(str1.equals("ccc"));
        /**
         * 测试用例2
         * "ccbabddf"
         * bab
         */
        String str2 =findLongestPalindrome("ccbabddf");
        System.out.println(str2.equals("bab"));
        /**
         * 测试用例3
         * "accbawgsfhbddddf"
         * dddd
         */
        String str3 =findLongestPalindrome("accbawgsfhbddddf");
        System.out.println(str3.equals("dddd"));

    }

}
