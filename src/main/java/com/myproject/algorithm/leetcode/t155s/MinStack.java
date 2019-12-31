package com.myproject.algorithm.leetcode.t155s;

public class MinStack {

    private int currentIndex = -1;

    private int[] stack;

    private int size = 0;

    private int minValue = 0;

    public MinStack() {
        stack = new int[8];
    }

    public void push(int x) {
        currentIndex++;
        size++;
        if (size == 1 || x < minValue) {
            minValue = x;
        }
        if (size > stack.length) {
            int[] tmpStack = new int[stack.length << 1];
            System.arraycopy(stack, 0, tmpStack, 0, stack.length);
            stack = tmpStack;
        }
        stack[currentIndex] = x;
    }

    public void pop() {
        size--;
        if (size > 0) {
            if (stack[currentIndex] == minValue) {
                minValue = stack[0];
                for (int i = 1; i < size; i++) {
                    if (stack[i] < minValue) {
                        minValue = stack[i];
                    }
                }
            }
        }
        currentIndex--;
    }

    public int top() {
        return stack[currentIndex];
    }

    public int getMin() {
        return minValue;
    }

}