package com.myproject.algorithm.poj.p1010;

import java.util.Arrays;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            // 创建一个长度为100的整型数组 ,用来保存邮票的面额
            int[] arr = new int[100];
            int n = 0;
            /**
             * 以下while循环的主要功能如下： 保存第一行的数据到arr[]中,以0作为结束标识
             */
            while (true) {//这里之所以用true,是因为后面会有专门的结束条件
                // 将输入的整数放到中
                int a = in.nextInt();
                // 如果a==0,则跳出循环,结束输入
                if (a == 0)
                    break;
                // 将a的值存入数组中
                arr[n++] = a;
            }
            // sort(arr,0,n).对指定 int 型数组的指定范围按数字升序进行排序
            // 排序的范围从索引 fromIndex（包括）一直到索引 toIndex（不包括）
            // 。（如果 fromIndex==toIndex，则排序范围为空。）
            // 使邮票的面额从小到大排列
            Arrays.sort(arr, 0, n);
            while (true) {
                // 将一个用户需要的邮票的总面值保存到a中
                int a = in.nextInt();
                // 如果a为0,跳出循环,结束输入
                if (a == 0){
                    break;
                }
                int ser = 0, num = 0, max = 0, a1 = 0, a2 = 0, a3 = 0, a4 = 0;
                //ser.需要用到的邮票的种类数
                //num.需要用到的邮票的张数
                //max.用来标记需要用到的邮票中面值最大的那张邮票
                //a1,a2,a3,a4分别用来作为需要用到的邮票的面额的下标
                // tie作为一个标记
                // 1)true，则证明存在多种邮票种类数相同,邮票数量相等,邮票面额的最大值也相等
                boolean tie = false;
                for (int i = 0; i < n; i++) {
                    // 如果当前邮票的面额大于游湖的需求,则跳出循环
                    // 因为有票的面额是从小到大存放在arr[]数组里面的
                    // ,如果当前邮票的面额都大于用户的需求,自然的，后面的也就不需要在进行处理了
                    if (arr[i] > a){
                        break;
                    }
                    // 如果当前邮票的面额==用户的总需求
                    if (arr[i] == a) {
                        /**
                         * 以下if语句的主要功能是：
                         * 如果当前的邮票的种类数为1，则证明,
                         * 第一张邮票的面额已经==用户的需求
                         * 所以将所用到的邮票的种类数ser记为1,
                         * 所用到的有票的张数记为1,
                         * 所用到的最大面额的邮票的下标记为为1,
                         * 因为只用到了一张邮票，所以a1,a2,a3,a4中就只用到了a1
                         * 将用到的邮票的面额的下标a1记为当前邮票的下标i
                         * (有人可能会问,为什么不计为1呢?《
                         * 
                         *   答：因遇到一张邮票就能满足用户需求时,不一定就是第一张邮票,
                         *   也有可能是前面的面额不够,进行了下一步的操作
                         *   
                         * )
                         */
                        if (ser == 0) {
                            ser = 1;
                            num = 1;
                            max = i;
                            a1 = i;
                            tie = false;
                        } else if (ser == 1 && num > 1) {
                            /**
                             * else if语句的主要功能是：
                             * 如果当前用到了两张或两张以上的同一种邮票,
                             * 又因为现在出现了一张邮票就能满足用户需求的情况,
                             * 所以,将
                             * 1)用到的邮票的种类数ser记为1
                             * 2)用到的邮票的数量num记为1,
                             * 3)用到的邮票的最大面额的的下标记为当前面额的下标
                             * 4)将tie记为false
                             */
                            ser = 1;
                            num = 1;
                            max = i;
                            a1 = i;
                            tie = false;
                        }
                    }
                    /**
                     * 以上的逻辑大致处理一下几种情况：
                     * 1)一张邮票的面额便大于用户的需求
                     * 2)一张邮票的面额恰好等于用户的需求
                     * 
                     * 以下开始主要处理一张邮票的面额满足不了用户的需求的情况
                     */
                    for (int j = i; j < n; j++) {//从当前不能满足用户需求的邮票开始,向下搜索
                        /**
                         * 如果当前邮票和当前邮票或后续邮票的面额之和大于用户需求
                         * 则,结束循环
                         * (为什么呢?后面的随便加一张都超额了,还不跳出循环那干什么)
                         */
                        if (arr[i] + arr[j] > a)
                            break;
                        /**
                         * 如果当前有票的面额和后面某一张邮票的面额之和==a
                         * ,即等于用户需求
                         */
                        if (arr[i] + arr[j] == a) {

                            //在两张邮票的面额之和能满足用户需求的情况下
                            //,所用到的邮票的种类至少是1种
                            int ser1 = 1;

                            /**
                             * 如果i!=j，则证明不是同一张邮票的面额*2==a(用户需求)
                             * 所以将所用到的有票的种类数+1
                             */
                            if (i != j)
                                ser1++;

/**
 * ser1 > ser的情况有以下几种：
 * 2>0.(不是那种一张邮票便>与用户需求的情况,而是一张邮票的面额<用户需求的情况)
 * 1>0(一张邮票满足不了用户的需求,但是两张同种类型的邮票便能满足用户的需求)
 * 2>1(这种情况应该不存在,我们做一下分析：
 * 1的情况应该是由一张邮票便能满足用户需求的情况产生,
 * 既然一张邮票的面额便能满足用户的需求,那么久肯定不会存在两张面额才能满足用户需求的情况
 * 即，如果a == b 那么 2a!=b ,不包括a、b都为0的情况)
 */
                            if (ser1 > ser) {

//将需要 用到的邮票的种类数更新为ser1
                                ser = ser1;

//将所用到的邮票的罪的面额的下标更新为j
//为什么是j呢,因为前面已经排序,越往后,面额越大
                                max = j;

//将需要用到的邮票的数量更新为2
                                num = 2;

//将需要用到的邮票面额的下标更新为i和j
                                a1 = i;
                                a2 = j;
                                tie = false;
                            } else if (ser1 == ser) {
//ser1 > ser.表明所用到的邮票的种类数相同,但是这时所用到的有票的张数不一定相同

/**
 * 
 * if语句的逻辑：
 * 如果所要用到的邮票数>2
 * 或者邮票数==2但是所用到的邮票的最大面值<当前这种情况邮票的最大面值
 * 则,
 * 将ser记为ser1,max记为j,num记为2,a1、a2分别记为i、j
 * 
 * if语句的处理逻辑主要准许你以下原则,用到的种类数尽可能多,用到的邮票数尽可能的少,用到的有票的面值尽可能的大
 */
                                if (num > 2 || (num == 2 && arr[max] < arr[j])) {
                                    ser = ser1;
                                    max = j;
                                    num = 2;
                                    a1 = i;
                                    a2 = j;
                                    tie = false;
                                } else if (num == 2 && arr[max] == arr[j])
//如果所用到的邮票的数量==2且所用到的邮票的最大面额相等
//则证明存在多种最优解
//因此，将tie记为true

                                    tie = true;
                            }
                        }


/**
 * 以下开始处理两张邮票无法解决问题时的情况
 * 以下两个for循环解决问题的思路和上面的一样，参照着分析即可,
 * 在这里就不再做详细的说明了
 */
                        for (int k = j; k < n; k++) {
                            if (arr[i] + arr[j] + arr[k] > a)
                                break;
                            if (arr[i] + arr[j] + arr[k] == a) {
                                int ser1 = 1;
                                if (i != j)
                                    ser1++;
                                if (j != k)
                                    ser1++;
                                if (ser1 > ser) {
                                    ser = ser1;
                                    max = k;
                                    num = 3;
                                    a1 = i;
                                    a2 = j;
                                    a3 = k;
                                    tie = false;
                                } else if (ser1 == ser) {
                                    if (num > 3
                                            || (num == 3 && arr[max] < arr[k])) {
                                        ser = ser1;
                                        max = k;
                                        num = 3;
                                        a1 = i;
                                        a2 = j;
                                        a3 = k;
                                        tie = false;
                                    } else if (num == 3 && arr[max] == arr[k])
                                        tie = true;
                                }
                            }
                            for (int w = k; w < n; w++) {
                                if (arr[i] + arr[j] + arr[k] + arr[w] > a)
                                    break;
                                if (arr[i] + arr[j] + arr[k] + arr[w] == a) {
                                    int ser1 = 1;
                                    if (i != j)
                                        ser1++;
                                    if (j != k)
                                        ser1++;
                                    if (k != w)
                                        ser1++;
                                    if (ser1 > ser) {
                                        ser = ser1;
                                        max = w;
                                        num = 4;
                                        a1 = i;
                                        a2 = j;
                                        a3 = k;
                                        a4 = w;
                                        tie = false;
                                    } else if (ser1 == ser && num == 4) {
                                        if (arr[w] > arr[max]) {
                                            max = w;
                                            a1 = i;
                                            a2 = j;
                                            a3 = k;
                                            a4 = w;
                                            tie = false;
                                        } else if (arr[w] == arr[max])
                                            tie = true;
                                    }
                                }
                            }
                        }
                    }
                }

//如果不存在一种情况满足用户需求
                if (num == 0)
                    System.out.println(a + " ---- none");

//如果存在多种情况满足用户需求
                else if (tie)
                    System.out.println(a + " (" + ser + "):" + " tie");

//分别用1、2、3、4张邮票解决问题的情况
                else {
                    System.out.print(a + " (" + ser + "):");
                    if (num == 1)
                        System.out.println(" " + arr[a1]);
                    else if (num == 2)
                        System.out.println(" " + arr[a1] + " " + arr[a2]);
                    else if (num == 3)
                        System.out.println(" " + arr[a1] + " " + arr[a2] + " "
                                + arr[a3]);
                    else if (num == 4)
                        System.out.println(" " + arr[a1] + " " + arr[a2] + " "
                                + arr[a3] + " " + arr[a4]);
                }
            }
        }
    }
}
