package com.myproject.algorithm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PriorityQueue;

public class Test {

    public void test() {
        int i = 8;
        while ((i -= 3) > 0) ;
        System.out.println("i = " + i);
    }

    public void test2() {
        Test test = new Test();
        for (int i = 0; i < 5_0000; i++) {
            test.test();
        }
    }

    public void test3() {
        PriorityQueue queue = new PriorityQueue();
        System.out.println("\u000C");
    }

    public void format() throws ParseException {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date newDate1 = format1.parse("2019-12-31 23:59:59");
        System.out.println(newDate1);

        SimpleDateFormat format2 = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        Date newDate2 = format2.parse("2019-12-31 23:59:59");
        System.out.println(newDate2);

        SimpleDateFormat format3 = new SimpleDateFormat("YYYY-MM-DD");
        Date newDate3 = format3.parse("2020-01-01");
        System.out.println(newDate3);

        SimpleDateFormat format4 = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate4 = format4.parse("2019-12-30");
        System.out.println(newDate4);

        SimpleDateFormat format5 = new SimpleDateFormat("YYYY");
        String format = format5.format(newDate4);
        System.out.println(format);
    }

    public static void main(String[] args) {

    }

}
