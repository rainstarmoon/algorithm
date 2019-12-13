package com.myproject.algorithm.leetcode.t771;

import java.util.HashMap;
import java.util.Map;

@Deprecated
public class Solution {

    public static void main(String[] args) {
        int i = new Solution().numJewelsInStones("aA", "aAAbbbb");
        System.out.println(i);
    }

    public int numJewelsInStones(String J, String S) {
        char[] sChars = S.toCharArray();
        char[] jChars = J.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sChars.length; i++) {
            Integer tmp = map.getOrDefault(sChars[i], 0);
            map.put(sChars[i], tmp + 1);
        }
        int num = 0;
        for (int i = 0; i < jChars.length; i++) {
            num += map.getOrDefault(jChars[i], 0);
        }
        return num;
    }

}
