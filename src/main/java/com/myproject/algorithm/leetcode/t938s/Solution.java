package com.myproject.algorithm.leetcode.t938s;

import com.myproject.algorithm.leetcode.common.TreeNode;

public class Solution {
    int ans = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        dfs(root, L, R);
        return ans;
    }

    public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R) {
                ans += node.val;
            }
            if (L < node.val) {
                dfs(node.left, L, R);
            }
            if (node.val < R) {
                dfs(node.right, L, R);
            }
        }
    }

}

