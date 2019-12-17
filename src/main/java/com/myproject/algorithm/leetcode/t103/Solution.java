package com.myproject.algorithm.leetcode.t103;

import com.myproject.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非常复杂
 * 还没有实现
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        List<List<Integer>> lists = new Solution().zigzagLevelOrder(root);
        System.out.println(lists);
    }

    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    Stack<TreeNode> stack = new Stack<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        stack.add(root);
        int i = 0;
        while (true) {
            if (stack.isEmpty()) {
                break;
            }
            if (levels.size() == i) {
                levels.add(new ArrayList<>());
            }
            TreeNode node = stack.pop();
            levels.get(i).add(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            i++;
        }
        return levels;
    }

}
