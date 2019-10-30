package com.myproject.algorithm.poj.poj1011;

import java.util.Arrays;
import java.util.Scanner;

//9
//8 3 8 15 2 11 4 8 1
//20
public class Main02 {
    // 木棍数
    static int num;
    // 长度数组
    static int[] lengthArray;
    // 使用标记数组
    static boolean[] usedArray;
    // 木棍总长
    static int total;

    static int mayLength;

    static int mayNum;

    static void init(String[] tokens) {
        lengthArray = new int[num];
        usedArray = new boolean[num];
        total = 0;
        for (int i = 0; i < num; i++) {
            lengthArray[i] = Integer.valueOf(tokens[i]);
            usedArray[i] = false;
            total += lengthArray[i];
        }
        Arrays.sort(lengthArray);
        mayLength = lengthArray[num - 1];
        // mayNum = 0;
    }

    static void initUsedArray() {
        for (int i = 0; i < num; i++) {
            usedArray[i] = false;
        }
    }

    public static boolean dfs(int currentLength, int currentNum, int index) {
        // 匹配成功
        if (currentLength == mayLength) {
            // 匹配数量加1
            currentNum++;
            // 初始长度重置
            currentLength = 0;
            // 索引左移
            index = num - 2;
        }
        if (currentNum == mayNum) {
            // 全部消耗完毕
            return true;
        }
        // 索引有效
        while (index >= 0) {
            if (usedArray[index]) {
                // 索引已经被使用，索引左移
                index--;
            } else {
                // 索引未被使用
                if (currentLength + lengthArray[index] <= mayLength) {
                    // 每个长度初始第一次，一定进入这个逻辑分支
                    // 可以继续匹配
                    // 使用标记
                    usedArray[index] = true;
                    // 递归匹配
                    if (dfs(currentLength + lengthArray[index], currentNum, index - 1)) {
                        // 消耗完毕匹配完成
                        return true;
                    }
                    // 标记回溯
                    usedArray[index] = false;
                    // 当前木棍长度为0，剩余木棍并不能再合成木棒，搜索失败
                    if (currentLength == 0) {
                        break;
                    }
                    // 可以合成一个当前的，但是剩余的不能合成一个木棒，搜索失败
                    if (currentLength + lengthArray[index] == mayLength) {
                        break;
                    }
                }
                int tempIndex = index - 1;
                while (tempIndex >= 0 && lengthArray[index] == lengthArray[tempIndex]) {
                    tempIndex--;
                }
                index = tempIndex;
                int restLength = 0;
                while (tempIndex >= 0) {
                    if (!usedArray[tempIndex]) {
                        restLength += lengthArray[tempIndex];
                    }
                    tempIndex--;
                }
                if (restLength < mayLength - currentLength) {
                    break;
                }
            }
        }
        // 没有匹配成功
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens;
        while ((num = Integer.valueOf(sc.nextLine())) != 0) {
            tokens = sc.nextLine().split(" ");
            // 初始化
            init(tokens);
            // 可能长度循环
            for (; mayLength <= total; mayLength++) {
                if (total % mayLength != 0) {
                    continue;
                }
                mayNum = total / mayLength;
                // 可能长度检验
                if (dfs(0, 0, num - 1)) {
                    System.out.println(mayLength);
                    break;
                }
                initUsedArray();
            }
        }
    }
}