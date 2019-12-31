package com.myproject.algorithm.leetcode.t112s;

import com.myproject.algorithm.leetcode.common.TreeNode;

@Deprecated
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        boolean b = new Solution().hasPathSum(root, 22);
        System.out.println(b);

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int nextTarget = sum - root.val;
        if (root.left == null && root.right == null) {
            return nextTarget == 0;
        }
        return hasPathSum(root.left, nextTarget) || hasPathSum(root.right, nextTarget);
    }


}
