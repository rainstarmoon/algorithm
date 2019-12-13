package com.myproject.algorithm.poj.p1003;

import java.util.Scanner;

@Deprecated
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double input = 0;
        while (true) {
            input = sc.nextDouble();
            if (input == 0d) {
                break;
            }
            double sum = 0;
            int i = 0;
            while (sum < input) {
                i++;
                sum += 1.0 / (1 + i);
            }
            System.out.println(i + " card(s)");
        }
    }
}