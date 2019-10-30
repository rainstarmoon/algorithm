package com.myproject.algorithm.test001;

public class Test {

    public static void main(String[] args) {
        TestA a = new TestB();
        TestB b = new TestB();
        System.out.println(a.i);
        System.out.println(b.i);
        System.out.println(a.getI());
        System.out.println(b.getI());
    }

}
