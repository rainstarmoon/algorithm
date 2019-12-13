package com.myproject.algorithm.poj.p1013;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        if (scan.hasNext()) {
            int n = Integer.parseInt(scan.nextLine().trim());
            for (int i = 0; i < n; i++) {
                boolean[] real = {false, false, false, false, false, false, false, false, false, false, false, false};
                int[] hy = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                String[] s1 = scan.nextLine().trim().split(" ");
                String[] s2 = scan.nextLine().trim().split(" ");
                String[] s3 = scan.nextLine().trim().split(" ");
                char[] c11 = s1[0].toCharArray();
                char[] c12 = s1[1].toCharArray();
                char[] c21 = s2[0].toCharArray();
                char[] c22 = s2[1].toCharArray();
                char[] c31 = s3[0].toCharArray();
                char[] c32 = s3[1].toCharArray();
                if (s1[2].equals("even")) {
                    for (int j = 0; j < c11.length; j++) {
                        real[c11[j] - 'A'] = true;
                    }
                    for (int j = 0; j < c12.length; j++) {
                        real[c12[j] - 'A'] = true;
                    }
                }
                if (s2[2].equals("even")) {
                    for (int j = 0; j < c21.length; j++) {
                        real[c21[j] - 'A'] = true;
                    }
                    for (int j = 0; j < c22.length; j++) {
                        real[c22[j] - 'A'] = true;
                    }
                }
                if (s3[2].equals("even")) {
                    for (int j = 0; j < c31.length; j++) {
                        real[c31[j] - 'A'] = true;
                    }
                    for (int j = 0; j < c32.length; j++) {
                        real[c32[j] - 'A'] = true;
                    }
                }



                if (s1[2].equals("up")) {
                    for (int j = 0; j < c11.length; j++) {
                        hy[c11[j] - 'A']++;
                    }
                    for (int j = 0; j < c12.length; j++) {
                        hy[c12[j] - 'A']--;
                    }
                }
                if (s2[2].equals("up")) {
                    for (int j = 0; j < c21.length; j++) {
                        hy[c21[j] - 'A']++;
                    }
                    for (int j = 0; j < c22.length; j++) {
                        hy[c22[j] - 'A']--;
                    }
                }
                if (s3[2].equals("up")) {
                    for (int j = 0; j < c31.length; j++) {
                        hy[c31[j] - 'A']++;
                    }
                    for (int j = 0; j < c32.length; j++) {
                        hy[c32[j] - 'A']--;
                    }
                }
                if (s1[2].equals("down")) {
                    for (int j = 0; j < c11.length; j++) {
                        hy[c11[j] - 'A']--;
                    }
                    for (int j = 0; j < c12.length; j++) {
                        hy[c12[j] - 'A']++;
                    }
                }
                if (s2[2].equals("down")) {
                    for (int j = 0; j < c21.length; j++) {
                        hy[c21[j] - 'A']--;
                    }
                    for (int j = 0; j < c22.length; j++) {
                        hy[c22[j] - 'A']++;
                    }
                }
                if (s3[2].equals("down")) {
                    for (int j = 0; j < c31.length; j++) {
                        hy[c31[j] - 'A']--;
                    }
                    for (int j = 0; j < c32.length; j++) {
                        hy[c32[j] - 'A']++;
                    }
                }
                int m = 0;
                for (int k = 0; k < real.length; k++) {
                    if (!real[k]) {
                        int max = Math.abs(hy[k]);
                        m = k;
                        for (int j = k + 1; j < hy.length; j++) {
                            if (Math.abs(hy[j]) > max && !real[j]) {
                                max = Math.abs(hy[j]);
                                m = j;
                            }
                        }
                        break;
                    }
                }
                char key = (char) ('A' + m);
                if (hy[m] > 0) {
                    System.out.println(key + " is the counterfeit coin and it is heavy.");
                } else {
                    System.out.println(key + " is the counterfeit coin and it is light.");
                }
            }
        }
    }
}
