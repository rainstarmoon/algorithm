package com.myproject.algorithm.poj.poj1006;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Deprecated
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        int p = 0, e = 0, i = 0, d = 0, count = 1;
        while (true) {
            p = sc.nextInt();
            e = sc.nextInt();
            i = sc.nextInt();
            d = sc.nextInt();
            if (p == -1 && e == -1 && i == -1 && d == -1) {
                break;
            }
            while (true) {
                i += 33;
                if (i % 28 == e % 28 && i % 23 == p % 23) {
                    e = i - d;
                    if (e > 21252) {
                        e %= 21252;
                    }
                    list.add("Case " + count++ + ": the next triple peak occurs in " + e + " days.");
                    break;
                }

            }
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}