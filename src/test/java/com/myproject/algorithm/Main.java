//package com.myproject.algorithm;
//
//import java.util.LinkedList;
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.next();
//        if (str == null || str.isEmpty()) {
//            return;
//        }
//        String[] strArr = str.split(",");
//
//        LinkedList<String> res = new LinkedList<>();
//
//        for (int i = 0; i < strArr.length; i++) {
//            int i1 = retIndex(strArr[i], res);
//            res.add(i1, strArr[i]);
//        }
//        for (int i = 0, length = res.size(); i < length; i++) {
//            System.out.print(res.get(i));
//            if (i < length - 1) {
//                System.out.print(",");
//            }
//        }
//    }
//
//    private static int retIndex(String str, LinkedList<String> list) {
//        for (int i = 0; i < list.size(); i++) {
//            char[] chars = str.toCharArray();
//            char charTmp = chars[chars.length - 1];
//            String s = list.get(i);
//            char[] chars2 = s.toCharArray();
//            char charTmp2 = chars2[chars2.length - 1];
//            if (charTmp > charTmp2) {
//                return i;
//            }
//        }
//        return list.size();
//    }
//
//}
