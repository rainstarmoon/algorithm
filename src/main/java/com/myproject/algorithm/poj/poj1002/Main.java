package com.myproject.algorithm.poj.poj1002;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

@Deprecated
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        TreeMap<String, Integer> treemap = new TreeMap<String, Integer>();
        int num = 1;
        StringBuilder phoneSpell = new StringBuilder(7);
        while (count-- > 0) {
            String phone = sc.next();
            char[] phoneSpilt = phone.toCharArray();
            for (char c : phoneSpilt) {
                if (c >= 82 && c <= 89) {
                    phoneSpell.append((c - 60) / 3);
                } else if (c >= 65 && c <= 80) {
                    phoneSpell.append((c - 59) / 3);
                } else if (c >= 48 && c <= 57) {
                    phoneSpell.append(c);
                }
            }
            phone = phoneSpell.toString();
            if (treemap.containsKey(phone)) {
                num = treemap.get(phone) + 1;
                treemap.put(phone, num);
            } else {
                treemap.put(phone, 1);
            }
            phoneSpell = new StringBuilder(7);
        }
        if (num == 1) {
            System.out.println("No duplicates.");
        } else {
            Set<String> key = treemap.keySet();
            for (String s : key) {
                count = treemap.get(s);
                if (count > 1) {
                    System.out.println(s.substring(0, 3) + "-" + s.substring(3) + " " + count);
                }
            }
        }
    }
}