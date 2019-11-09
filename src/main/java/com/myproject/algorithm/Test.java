package com.myproject.algorithm;

import java.util.PriorityQueue;

public class Test {

    //public static void main(String[] args) {

        //PriorityQueue queue = new PriorityQueue();

        //System.out.println("\u000C");
    //}
	
	public void test() {
        int i = 8;
        while ((i -= 3) > 0) ;
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        Test test = new Test();
        for (int i = 0; i < 5_0000; i++) {
            test.test();
        }
    }


}
