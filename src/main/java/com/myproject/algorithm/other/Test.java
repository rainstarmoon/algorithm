package com.myproject.algorithm.other;

/**
 * @author 夏泽宇
 * 编程
 * 有char型数组words，由空格以及字母组成。 我们定义被空格隔离开的字符序列为一个单词。
 * 现需要对其处理，把连续的空格换成一个空格，把单词的首字母大写。
 * 要求：1. 在原有数组上操作，不得开辟新的数组空间。 2. 性能也要考虑优化。
 * void processWords(char[] words)
 * <p>
 * a,b,c, , ,d,e, ,f
 * A,b,c, ,D,e, ,F
 * <p>
 * ,a,b,c, , ,d,e, ,f
 * ,A,b,c, ,D,e, ,F
 */
public class Test {

    public static void main(String[] args) {
        

    }

    public void processWords(char[] words) {
        int end = 0;
        boolean isBegin = true; // 是否是首字母
        boolean lastIsBlank = false;// 上一个是否是空格
        for (int begin = 0; begin < words.length; begin++) {
            if (words[begin] == ' ') {
                if (!lastIsBlank) {
                    lastIsBlank = true;
                    words[end] = ' ';
                    end++;
                }
                isBegin = true;
            } else {
                if (isBegin) {
                    words[end] = (char) (words[begin] - 32);
                } else {
                    words[end] = words[begin];
                }
                isBegin = false;
                lastIsBlank = false;
                end++;
            }
        }
    }

}
