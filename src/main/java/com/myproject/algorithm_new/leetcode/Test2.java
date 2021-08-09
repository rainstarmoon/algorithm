package com.myproject.algorithm_new.leetcode;

import java.util.*;

/**
 * @author 夏泽宇
 * <p>
 * 通过RangeTableIndex 实现一个索引，索引的key为Range<Integer>（前闭后开），
 * <p>
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
 * ￼
 */
public class Test2 {


}

class Range {
    private TreeMap<RangeKey, List<Integer>> map = new TreeMap<>();
    public List<Integer> get(Integer input) {
        Set<Integer> result = new HashSet<>();
        Boolean flag = null;
        for (Map.Entry<RangeKey, List<Integer>> rangeKeyListEntry : map.entrySet()) {
            if (rangeKeyListEntry.getKey().isExist(input)) {
                result.addAll(rangeKeyListEntry.getValue());
                flag = true;
            } else {
                if (flag != null && flag) {
                    break;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
class RangeKey implements Comparable<RangeKey> {
    private int beginIndex;
    private int endIndex;
    public boolean isExist(Integer input) {
        if (input >= beginIndex && input < endIndex) {
            return true;
        }
        return false;
    }
    @Override
    public int compareTo(RangeKey key) {
        int result = this.beginIndex - key.beginIndex;
        if (result == 0) {

        }
        return result;
    }
}