package com.myproject.algorithm.leetcode.t58s;

public class Solution {

    public static void main(String[] args) {
        int length = new Solution().lengthOfLastWord("a    ");
        System.out.println(length);
    }

    public int lengthOfLastWord(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        int i = length - 1;
        boolean isEndFlag = true;
        while (i >= 0) {
            if(chars[i] == ' '){
                if(isEndFlag){
                    length--;
                }else{
                    break;
                }
            }else{
                isEndFlag = false;
            }
            i--;
        }
        return length - 1 - i;
    }

}
