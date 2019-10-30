package com.myproject.algorithm.util;

import java.util.Arrays;

public class MyPriorityQueue {

    private int[] array;
    private int size; // 当前队列长度

    public MyPriorityQueue() {
        this.array = new int[8];
    }

    /**
     * 出入数据
     *
     * @param value 要插入的数据
     */
    public void enQueue(int value) {
        // 先判断队列长度是否超出范围，是则扩容
        if (size >= array.length) {
            reSize();
        }
        array[size++] = value;
        upAdjust();
    }

    /**
     * 取出堆顶数据，并删除（置零）数组最后一个数据
     *
     * @return 堆顶数据
     */
    public int deQueue() {
        int res = array[0];
        array[0] = array[--size];
        array[size] = 0;
        downAdjust();
        return res;
    }

    /**
     * 扩容
     */
    private void reSize() {
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array, newSize);
    }

    /**
     * 上浮操作
     */
    private void upAdjust() {
        int childrenIndex = size - 1;
        int parentIndex = (childrenIndex - 1) / 2;
        // 先保存刚插入的叶子节点的值，用于最后赋值
        int temp = array[childrenIndex];
        // 开始上浮操作
        while (childrenIndex > 0 && temp < array[parentIndex]) {
            // 直接单向赋值，无需转换
            array[childrenIndex] = array[parentIndex];
            childrenIndex = parentIndex;
            parentIndex = (childrenIndex - 1) / 2;
        }
        // 最后赋值
        array[childrenIndex] = temp;
    }

    /**
     * 下沉操作
     */
    private void downAdjust() {
        int parentIndex = 0;
        int temp = array[parentIndex];
        int length = size - 1;
        // 假设有左子节点，先求出左子节点的下标
        int childrenIndex = 2 * parentIndex + 1;
        // 当确实是有左子节点时
        while (childrenIndex <= length) {
            // 如果有右子节点且左子节点大于右子节点时，则将 childrenIndex 设置为右子节点的下标值
            if ((childrenIndex + 1) <= length && array[childrenIndex + 1] < array[childrenIndex]) {
                childrenIndex++;
            }
            // 如果无需下沉，则直接跳出循环
            if (temp <= array[childrenIndex]) {
                break;
            }
            // 接下来才是真正的下沉
            array[parentIndex] = array[childrenIndex];
            parentIndex = childrenIndex;
            childrenIndex = 2 * parentIndex + 1;
        }
        // 最后的赋值
        array[parentIndex] = temp;
    }

    @Override
    public String toString() {
        System.out.println(Arrays.toString(this.array));
        return null;
    }

    public static void main(String[] args) {
        MyPriorityQueue priorityQueue = new MyPriorityQueue();
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(6);
        priorityQueue.enQueue(9);
        priorityQueue.enQueue(8);
        priorityQueue.enQueue(6);
        priorityQueue.enQueue(7);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(4);
        priorityQueue.enQueue(6);
        priorityQueue.enQueue(3);
        priorityQueue.toString();
        System.out.println("堆顶数据：" + priorityQueue.deQueue());
        priorityQueue.toString();
    }
}
