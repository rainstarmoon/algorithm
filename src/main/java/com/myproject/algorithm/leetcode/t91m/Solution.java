package com.myproject.algorithm.leetcode.t91m;

import java.util.HashMap;
import java.util.Map;

@Deprecated
public class Solution {

    public static void main(String[] args) {
        int i = new Solution().numDecodings("10");
        System.out.println(i);
    }

    Map<String, Integer> map = new HashMap<>();

    public int numDecodings(String s) {
        if (map.get(s) != null) {
            return map.get(s);
        }
        if (s == null || s.length() == 0) {
            map.put(s, 0);
            return 0;
        }
        if (s.length() == 1 && !s.equals("0")) {
            map.put(s, 1);
            return 1;
        }
        if (s.length() == 2) {
            if (Integer.valueOf(s) == 10 || Integer.valueOf(s) == 20) {
                map.put(s, 1);
                return 1;
            }
            if (Integer.valueOf(s) <= 26 && Integer.valueOf(s) > 10 && Integer.valueOf(s) != 20) {
                map.put(s, 2);
                return 2;
            }
            if (Integer.valueOf(s) < 10) {
                map.put(s, 0);
                return 0;
            }
        }
        int count = 0;
        String tmp1 = s.substring(0, 1);
        if (!tmp1.equals("0")) {
            count += numDecodings(s.substring(1));
        }
        if (s.length() >= 2) {
            String tmp2 = s.substring(0, 2);
            if (Integer.valueOf(tmp2) <= 26 && Integer.valueOf(tmp2) >= 10) {
                count += numDecodings(s.substring(2));
            }
        }
        map.put(s, count);
        return count;
    }

}
