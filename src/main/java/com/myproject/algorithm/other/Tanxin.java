package com.myproject.algorithm.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tanxin {
    public static void main(String[] args) {
        List<Goods> goodsList = new ArrayList<>();
        // todo add element（元素） and maxweight（最大重量）
        List<Integer> max = new Tanxin().getMax(goodsList, 100);
        // 输出为物品序号
        System.out.println(max);
    }
    public List<Integer> getMax(List<Goods> goodsList, int c) {
        List<Integer> result = new ArrayList<>();
        int tmpWeight = 0;
        Collections.sort(goodsList);
        for (Goods goods : goodsList) {
            if (tmpWeight + goods.weight <= c) {
                result.add(goods.no);
                tmpWeight += goods.weight;
            }
        }
        return result;
    }
}
class Goods implements Comparable<Goods> {
    public int no;
    public int weight;
    public int value;
    public double ratio;
    public Goods(int no, int weight, int value) {
        this.no = no;
        this.weight = weight;
        this.value = value;
        this.ratio = ((double) value) / weight;
    }
    @Override
    public int compareTo(Goods o) {
        return -Double.compare(ratio, o.ratio);
    }
}