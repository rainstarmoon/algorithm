package com.myproject.algorithm_new.leetcode;

import java.util.*;

/**
 * 通过RangeTableIndex 实现一个索引，索引的key为Range<Integer>（前闭后开），
 * 索引的value为具体的匹配的值，举例说明：
 * 1.调用put向里面放入key=[1,3), value=[1,2,3,4],
 * 则调用get时满足
 * get(1)=[1,2,3,4]
 * get(2)=[1,2,3,4]
 * get(0)=[]
 * get(3)=[]
 * get(4)=[]
 * 2.再继续调用put向里面放入key=[2,1000000), value=1,5,6,7，
 * 则调用get时满足
 * get(1)=[1,2,3,4]
 * get(2)=[1,2,3,4,5,6,7]
 * get(3)=[1,5,6,7]
 * get(4)=[1,5,6,7]
 * get(0)=[]
 * get(9999)=[1,5,6,7]
 */

/**
 * {
 * [1,10]:""
 * }
 * --------------------------------------------------
 * add:[5,+无穷]
 * {
 * [1,5]:""
 * [5,10]:""
 * [10,+无穷]:""
 * }
 * --------------------------------------------------
 * add:[2,3]
 * {
 * [1,2]:""
 * [2,3]:""
 * [3,5]:""
 * [5,10]:""
 * [10,+无穷]:""
 * }
 * --------------------------------------------------
 * add:[4,8]
 * {
 * [1,2]:""
 * [2,3]:""
 * [3,4]:""
 * [4,5]:""
 * [5,8]:""
 * [8,10]:""
 * [10,+无穷]:""
 * }
 */
public class RangeTable {

    public static void main(String[] args) {
        RangeTable rangeTable = new RangeTable();
        rangeTable.put(1, 10, Arrays.asList(1, 2, 3, 4));
        rangeTable.put(5, 100, Arrays.asList(5, 6, 7));
        rangeTable.put(2, 3, Arrays.asList(5, 6, 7));
        rangeTable.put(4, 8, Arrays.asList(5, 6, 7));
        rangeTable.put(200, 300, Arrays.asList(5, 6, 7));
        rangeTable.put(9, null, Arrays.asList(5, 6, 7));

        System.out.println(rangeTable);
    }

    private final TreeMap<RangeKey, TreeSet<Integer>> innerMap = new TreeMap<>();

    public void put(Integer beginIndex, Integer endIndex, List<Integer> list) {
        TreeMap<RangeKey, TreeSet<Integer>> tmpInnerMap = new TreeMap<>();
        if (innerMap.isEmpty()) {
            RangeKey rangeKey = new RangeKey(beginIndex, endIndex);
            innerMap.put(rangeKey, new TreeSet<>(list));
        } else {
            Set<Map.Entry<RangeKey, TreeSet<Integer>>> entries = innerMap.entrySet();
            RangeKey tmpBeginRangeKey = null;
            TreeSet<Integer> tmpBeginValue = null;
            RangeKey tmpEndRangeKey = null;
            TreeSet<Integer> tmpEndValue = null;
            for (Map.Entry<RangeKey, TreeSet<Integer>> entry : entries) {
                if (tmpBeginRangeKey == null) {
                    RangeKey key = entry.getKey();
                    TreeSet<Integer> value = entry.getValue();
                    if (key.beginIndex <= beginIndex) {
                        if (key.endIndex == null) {
                            // 右边界为正无穷
                            key.endIndex = beginIndex;
                            tmpBeginRangeKey = new RangeKey(beginIndex, null);
                            tmpBeginValue = new TreeSet<>(list);
                            tmpBeginValue.addAll(value);
                            tmpInnerMap.put(tmpBeginRangeKey, tmpBeginValue);
                        } else if (key.endIndex > beginIndex) {
                            // 恰巧在区间中
                            Integer tmp = key.endIndex;
                            key.endIndex = beginIndex;
                            tmpBeginRangeKey = new RangeKey(beginIndex, tmp);
                            tmpBeginValue = new TreeSet<>(list);
                            tmpBeginValue.addAll(value);
                            tmpInnerMap.put(tmpBeginRangeKey, tmpBeginValue);
                        }
                    }
                }
                if (tmpBeginRangeKey != null) {
                    RangeKey key = null;
                    TreeSet<Integer> value = null;
                    if (tmpEndRangeKey == null) {
                        key = tmpBeginRangeKey;
                        value = tmpBeginValue;
                    } else {
                        key = entry.getKey();
                        value = entry.getValue();
                    }
                    tmpEndRangeKey = key;
                    if (endIndex == null) {
                        if (key.endIndex == null) {
                            value.addAll(new TreeSet<>(list));
                            break;
                        } else {
                            value.addAll(new TreeSet<>(list));
                        }
                    } else {
                        if (key.endIndex == null) {
                            key.endIndex = endIndex;
                            tmpEndRangeKey = new RangeKey(endIndex, null);
                            tmpEndValue = new TreeSet<>(list);
                            tmpEndValue.addAll(value);
                            tmpInnerMap.put(tmpEndRangeKey, tmpEndValue);
                            break;
                        } else if (key.endIndex <= endIndex) {
                            value.addAll(list);
                        } else if (key.endIndex > endIndex) {
                            Integer tmp = key.endIndex;
                            key.endIndex = endIndex;
                            tmpEndRangeKey = new RangeKey(endIndex, tmp);
                            tmpEndValue = new TreeSet<>(list);
                            tmpEndValue.addAll(value);
                            tmpInnerMap.put(tmpEndRangeKey, tmpEndValue);
                            break;
                        }
                    }
                }
            }
            if (tmpBeginRangeKey == null) {
                RangeKey tmpRangeKey = new RangeKey(beginIndex, endIndex);
                tmpInnerMap.put(tmpRangeKey, new TreeSet<>(list));
            } else {
                if (endIndex == null && tmpEndRangeKey.endIndex != null) {
                    RangeKey tmpRangeKey = new RangeKey(tmpEndRangeKey.endIndex, null);
                    tmpInnerMap.put(tmpRangeKey, new TreeSet<>(list));
                }
            }
            innerMap.putAll(tmpInnerMap);
        }
    }

    public List<Integer> get(Integer key) {
        TreeSet<Integer> lastSet = null;
        for (Map.Entry<RangeKey, TreeSet<Integer>> entry : innerMap.entrySet()) {
            if (key < entry.getKey().beginIndex) {
                break;
            } else if (key.equals(entry.getKey().beginIndex)) {
                lastSet = entry.getValue();
                break;
            } else {
                lastSet = entry.getValue();
            }
        }
        if (lastSet != null) {
            return new ArrayList<>(lastSet);
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<RangeKey, TreeSet<Integer>> entry : innerMap.entrySet()) {
            builder.append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n");
        }
        return builder.toString();
    }

    private static class RangeKey implements Comparable<RangeKey> {

        private Integer beginIndex;
        private Integer endIndex;

        public RangeKey(Integer beginIndex, Integer endIndex) {
            this.beginIndex = beginIndex;
            this.endIndex = endIndex;
        }

        @Override
        public int compareTo(RangeKey o) {
            return this.beginIndex - o.beginIndex;
        }

        @Override
        public String toString() {
            return "[" + beginIndex + "," + endIndex + ")";
        }
    }

}
