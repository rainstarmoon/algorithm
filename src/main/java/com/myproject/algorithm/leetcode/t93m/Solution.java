package com.myproject.algorithm.leetcode.t93m;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * <p>
 * 输入: "010010"
 * 输出: ["0.10.0.10","0.100.1.0"]
 */
@Deprecated
public class Solution {

    public static void main(String[] args) {
        List<String> strings = new Solution().restoreIpAddresses("010010");
        System.out.println(strings);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        int index2 = 1;
        int index3 = 2;
        int index4 = 3;

        while (true) {
            String ip1 = s.substring(0, index2);
            if (isVaild(ip1)) {
                String ip2 = s.substring(index2, index3);
                if (isVaild(ip2)) {
                    String ip3 = s.substring(index3, index4);
                    if (isVaild(ip3)) {
                        String ip4 = s.substring(index4);
                        if (isVaild(ip4)) {
                            result.add(ip1 + "." + ip2 + "." + ip3 + "." + ip4);
                        }
                    }
                }
            }
            index4++;
            if (index4 >= s.length()) {
                index3++;
                if (index3 >= s.length() - 1) {
                    index2++;
                    if (index2 >= s.length() - 2) {
                        break;
                    }
                    index3 = index2 + 1;
                }
                index4 = index3 + 1;
            }
        }
        return result;
    }

    private boolean isVaild(String ipPart) {
        if (ipPart.length() > 3) {
            return false;
        }
        if (ipPart.length() > 1 && ipPart.indexOf("0") == 0) {
            return false;
        }
        if (Integer.valueOf(ipPart) > 255) {
            return false;
        }
        return true;
    }

}
