package com.myproject.algorithm.leetcode.t1309s;

@Deprecated
public class Solution {

    public static void main(String[] args) {
        String s = new Solution().freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#");
        System.out.println(s);
    }

    public String freqAlphabets(String s) {
        StringBuilder builder = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            char tmpChar = s.charAt(i);
            if ('#' == tmpChar) {
                builder.append((char) (Integer.valueOf(s.substring(i - 2, i)) - 1 + 'a'));
                i -= 3;
            } else {
                builder.append((char) (Integer.valueOf(s.substring(i, i + 1)) - 1 + 'a'));
                i -= 1;
            }
        }
        StringBuilder reverse = builder.reverse();
        return reverse.toString();
    }

}
