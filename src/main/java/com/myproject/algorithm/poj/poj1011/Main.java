package com.myproject.algorithm.poj.poj1011;

import java.util.Arrays;
import java.util.Scanner;

@Deprecated
public class Main {
    // 木棍数
    static int num;
    // 长度数组
    static int[] lengthArray;
    // 使用标记数组
    static boolean[] usedArray;
    // 木棍总长
    static int total;
    // 可能的长度
    static int mayLength;
    // 可能的数量
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
    }

    static void initUsedArray() {
        for (int i = 0; i < num; i++) {
            usedArray[i] = false;
        }
    }

    static boolean dfs(int currentLength, int currentNum, int index) {
        if (currentNum == mayNum) {
            // 全部木棍消耗完毕
            // 递归结束
            return true;
        }
        while (index >= 0) {
            if (usedArray[index]) {
                // 索引已经被使用，索引左移
                index--;
            } else {
                if (currentLength + lengthArray[index] > mayLength) {
                    index = leftMoveIndex(index, currentLength);
                } else if (currentLength + lengthArray[index] < mayLength) {
                    usedArray[index] = true;
                    if (dfs(currentLength + lengthArray[index], currentNum, index - 1)) {
                        return true;
                    }
                    usedArray[index] = false;
                    if (currentLength == 0) {
                        // 初始状态进入递归，不允许左移索引，因为匹配失败，应该直接退出
                        return false;
                    }
                    index = leftMoveIndex(index, currentLength);
                } else if (currentLength + lengthArray[index] == mayLength) {
                    usedArray[index] = true;
                    // 匹配数量加1
                    // 初始长度重置
                    // 索引左移
                    if (dfs(0, currentNum + 1, num - 2 - currentNum)) {
                        return true;
                    }
                    usedArray[index] = false;
                    return false;
                }
            }
        }
        // 本次匹配无可用索引
        // 递归结束，mayLength 调整
        return false;
    }

    // 索引一般左移 -1 就行，因为使用了
    // 索引特殊左移，因为没有使用，所有等效索引可以直接排除
    // 如果不存在有效索引，返回 -1
    static int leftMoveIndex(int index, int currentLength) {
        // 索引初始化，原索引左边一格
        int tempIndex = index - 1;
        // 判断索引是否等效，通过索引对应value 是否相等
        while (tempIndex >= 0 && lengthArray[index] == lengthArray[tempIndex]) {
            tempIndex--;
        }
        index = tempIndex;
        // 判断索引时候有效，通过剩余木棍长度和 是否足够
        int restLength = 0;
        while (tempIndex >= 0) {
            if (!usedArray[tempIndex]) {
                restLength += lengthArray[tempIndex];
            }
            tempIndex--;
        }
        if (restLength < mayLength - currentLength) {
            return -1;
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens;
        while ((num = Integer.valueOf(sc.nextLine())) != 0) {
            tokens = sc.nextLine().split(" ");
            // 初始化
            init(tokens);
            // 可能长度循环
            for (mayLength = lengthArray[num - 1]; mayLength <= total; mayLength++) {
                if (total % mayLength != 0) {
                    continue;
                }
                mayNum = total / mayLength;
                // 可能长度检验
                if (dfs(0, 0, num - 1)) {
                    System.out.println(mayLength);
                    break;
                }
                // 重置使用使用数组
                initUsedArray();
            }
        }
    }
}