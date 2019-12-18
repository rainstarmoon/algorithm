package com.myproject.algorithm.leetcode.t1108;

/**
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * <p>
 * 示例 2：
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 */
@Deprecated
public class Solution {

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

}
