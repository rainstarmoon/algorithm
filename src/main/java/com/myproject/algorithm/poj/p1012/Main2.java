package com.myproject.algorithm.poj.p1012;

public class Main2 {

    public static void main(String[] args) {
        int k, m;
        for (k = 1; k < 14; k++) {
            for (m = k + 1; ; m++) {
                if (test(k, m)) {
                    System.out.println(k + " : " + m);
                    break;
                }
            }
        }
    }

    private static boolean test(int k, int m) {
        int i, t = 0, curr = 2 * k;
        for (i = 1; i <= k; i++) {
            t = (t + m - 1) % curr;
            curr--;
            if (t < k) {
                return false;
            }
        }
        return true;
    }

}