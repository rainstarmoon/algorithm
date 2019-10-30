package com.myproject.algorithm.poj.poj1001;

import java.math.BigDecimal;
import java.util.Scanner;

@Deprecated
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        String r = null;
        while (sc.hasNext()) {
            r = sc.next();
            n = sc.nextInt();
            BigDecimal bd = new BigDecimal(r);
            BigDecimal result = bd.pow(n);
            r = result.stripTrailingZeros().toPlainString();
            if (r.startsWith("0")) {
                r = r.substring(1);
            }
            System.out.println(r);
        }
        sc.close();
    }
}