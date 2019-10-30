package com.myproject.algorithm.poj.poj1007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Deprecated
public class Main {

    public static class Node implements Comparable<Node> {

        private Integer id;
        private String value;
        private int unsortednessNum;

        public Node(Integer id, String value) {
            this.id = id;
            this.value = value;
            this.unsortednessNum = calcUnsortednessNum();
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getUnsortednessNum() {
            return unsortednessNum;
        }

        public void setUnsortednessNum(int unsortednessNum) {
            this.unsortednessNum = unsortednessNum;
        }

        private int calcUnsortednessNum() {
            int num = 0;
            int length = value.length();
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    if (value.charAt(i) > value.charAt(j)) {
                        num++;
                    }
                }
            }
            return num;
        }

        @Override
        public int compareTo(Node node) {
            return unsortednessNum - node.getUnsortednessNum();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 第一个参数没啥用
        in.nextInt();
        // 输入行数
        int rows = in.nextInt();
        List<Node> list = new ArrayList<Node>();
        for (int i = 0; i < rows; i++) {
            list.add(new Node(i, in.next()));
        }
        Collections.sort(list);
        for (Node node : list) {
            System.out.println(node.getValue());
        }
    }
}