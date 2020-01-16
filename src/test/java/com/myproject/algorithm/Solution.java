package com.myproject.algorithm;

public class Solution {
    private A a =new A(1);
    public static void main(String[] args) {
        Solution solution = new Solution();
        A a = solution.getA();
        System.out.println(a);
        a= new A(2);
        System.out.println(solution.getA());
    }
    public A getA() {
        return a;
    }
}
class A{
    int a;
    public A(int a){
        this.a = a;
    }

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                '}';
    }
}