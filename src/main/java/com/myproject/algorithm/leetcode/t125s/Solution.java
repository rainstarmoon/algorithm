package com.myproject.algorithm.leetcode.t125s;

@Deprecated
public class Solution {

    public static void main(String[] args) {

        boolean palindrome = new Solution().isPalindrome("0P");
        System.out.println(palindrome);

    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int begIndex = 0;
        int endIndex = chars.length - 1;
        while (begIndex < endIndex) {
            char beg = chars[begIndex];
            char end = chars[endIndex];
            if (beg >= 65 && beg <= 90) {
                beg = (char) (beg + 32);
            } else if (beg >= 97 && beg <= 122 || beg >= 48 && beg <= 57) {
            } else {
                begIndex++;
                continue;
            }
            if (end >= 65 && end <= 90) {
                end = (char) (end + 32);
            } else if (end >= 97 && end <= 122 || end >= 48 && end <= 57) {
            } else {
                endIndex--;
                continue;
            }
            if (beg != end) {
                return false;
            }
            begIndex++;
            endIndex--;
        }
        return true;
    }


}
