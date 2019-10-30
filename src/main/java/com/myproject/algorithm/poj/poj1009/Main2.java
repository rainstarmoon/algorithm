package com.myproject.algorithm.poj.poj1009;

import java.util.*;

public class Main2 {

    public static class Node {
        public int value;
        public int num;

        public Node(int value, int num) {
            this.value = value;
            this.num = num;
        }
    }

    private static int[] indexOffsetArr = new int[8];

    private static void buildIndexOffsetArr(int colNum) {
        colNumGlobal = colNum;
        indexOffsetArr[0] = -colNum - 1;
        indexOffsetArr[1] = -colNum;
        indexOffsetArr[2] = -colNum + 1;
        indexOffsetArr[3] = -1;
        indexOffsetArr[4] = 1;
        indexOffsetArr[5] = colNum - 1;
        indexOffsetArr[6] = colNum;
        indexOffsetArr[7] = colNum + 1;
    }

    private static int colNumGlobal = 0;

    private static boolean firstFlag = true;

    private static int intTime = 0;

    private static int currentTotal = 0;

    private static TreeMap<Integer, Integer> inMap = new TreeMap<Integer, Integer>();

    private static List<Node> outList = new ArrayList<Node>();

    private static Node lastNode = null;

    private static int indexBegin = 0;

    private static int indexEnd = 0;

    private static int[] indexValueArr = new int[8];

    private static int changeIndex = 0;

    private static void initIndexValueArr() {
        changeIndex = 0;
    }

    private static void addValueToIndexValueArr(int value) {
        for (int i = 0; i < changeIndex; i++) {
            if (indexValueArr[i] == value) {
                return;
            }
        }
        indexValueArr[changeIndex] = value;
        changeIndex++;
    }

    private static int buildInData(int value, int num) {
        currentTotal = num + currentTotal;
        inMap.put(currentTotal, value);
        return currentTotal;
    }

    private static boolean checkNeedExecute(int index) {
        for (Integer key : inMap.keySet()) {
            indexEnd = key;
            if (index + 1 > indexEnd) {
                indexBegin = indexEnd;
                continue;
            } else {
                break;
            }
        }
        if (index - colNumGlobal > indexBegin && index + colNumGlobal < indexEnd) {
            return true;
        }
        return false;
    }


    private static Integer getValueByIndex(int index) {
        for (Map.Entry<Integer, Integer> entry : inMap.entrySet()) {
            int indexNum = entry.getKey();
            if (index + 1 > indexNum) {
                continue;
            } else {
                return entry.getValue();
            }
        }
        return null;
    }


    private static void getIndexArr(int index) {
        initIndexValueArr();
        int indexReal = index % colNumGlobal;
        if (indexReal == 0) {
            for (int i = 0; i < indexOffsetArr.length; i++) {
                if (i == 0 || i == 3 || i == 5) {
                    continue;
                }
                int indexNew = index + indexOffsetArr[i];
                if (indexNew < 0 || indexNew >= currentTotal) {
                    continue;
                }
                addValueToIndexValueArr(getValueByIndex(indexNew));
            }
        } else if (indexReal == colNumGlobal - 1) {
            for (int i = 0; i < indexOffsetArr.length; i++) {
                if (i == 2 || i == 4 || i == 7) {
                    continue;
                }
                int indexNew = index + indexOffsetArr[i];
                if (indexNew < 0 || indexNew >= currentTotal) {
                    continue;
                }
                addValueToIndexValueArr(getValueByIndex(indexNew));
            }
        } else {
            for (int i = 0; i < indexOffsetArr.length; i++) {
                int indexNew = index + indexOffsetArr[i];
                if (indexNew < 0 || indexNew >= currentTotal) {
                    continue;
                }
                addValueToIndexValueArr(getValueByIndex(indexNew));
            }
        }
    }

    private static int getMaxValue(int index) {
        int value = 0;
        int valueOld = getValueByIndex(index);
        for (int i = 0; i < changeIndex; i++) {
            int abs = valueOld - indexValueArr[i];
            abs = (abs < 0) ? -abs : abs;
            if (abs > value) {
                value = abs;
            }
        }
        return value;
    }

    private static void buildOutData(int value, int num) {
        if (lastNode == null) {
            lastNode = new Node(value, num);
            outList.add(lastNode);
        } else {
            if (value == lastNode.value) {
                lastNode.num += num;
            } else {
                lastNode = new Node(value, num);
                outList.add(lastNode);
            }
        }
    }

    private static void showOutData() {
        for (Node node : outList) {
            System.out.println(new StringBuilder().append(node.value).append(" ").append(node.num));
        }
    }

    private static void execute() {
        for (int index = 0; index < currentTotal; ) {
            if (checkNeedExecute(index)) {
                int indexTmp = indexEnd - colNumGlobal;
                buildOutData(0, indexTmp - index);
                index = indexTmp;
            } else {
                getIndexArr(index);
                int maxValue = getMaxValue(index);
                buildOutData(maxValue, 1);
                index++;
            }
        }
        showOutData();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in1 = -1;
        int in2 = -1;
        while (true) {
            int inInt = sc.nextInt();
            if (firstFlag) {
                firstFlag = false;
                System.out.println(inInt);
                if (inInt == 0) {
                    break;
                }
                buildIndexOffsetArr(inInt);
            } else {
                intTime++;
                if (intTime == 1) {
                    in1 = inInt;
                } else {
                    in2 = inInt;
                }
                if (in1 == 0 && in2 == 0) {
                    execute();
                    inMap.clear();
                    outList.clear();
                    lastNode = null;
                    currentTotal = 0;
                    firstFlag = true;
                    intTime = 0;
                    System.out.println(new StringBuilder().append(in1).append(" ").append(in2));
                    continue;
                }
                if (intTime == 2) {
                    buildInData(in1, in2);
                    intTime = 0;
                }
            }
        }
    }
}