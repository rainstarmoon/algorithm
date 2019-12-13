package com.myproject.algorithm.leetcode.tLCP1;

@Deprecated
public class Solution {
    public int game(int[] guess, int[] answer) {
        if (guess == null || answer == null || guess.length != answer.length) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                num++;
            }
        }
        return num;
    }
}
