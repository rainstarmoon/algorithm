package com.myproject.algorithm.poj.p1008;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Deprecated
public class Main {

    public static void main(String[] args) {
        Map<String, Integer> haab = new HashMap<String, Integer>();
        haab.put("pop", 0);
        haab.put("no", 1);
        haab.put("zip", 2);
        haab.put("zotz", 3);
        haab.put("tzec", 4);
        haab.put("xul", 5);
        haab.put("yoxkin", 6);
        haab.put("mol", 7);
        haab.put("chen", 8);
        haab.put("yax", 9);
        haab.put("zac", 10);
        haab.put("ceh", 11);
        haab.put("mac", 12);
        haab.put("kankin", 13);
        haab.put("muan", 14);
        haab.put("pax", 15);
        haab.put("koyab", 16);
        haab.put("cumhu", 17);
        haab.put("uayet", 18);

        Map<Integer, String> tzolkin = new HashMap<Integer, String>();
        tzolkin.put(1, "imix");
        tzolkin.put(2, "ik");
        tzolkin.put(3, "akbal");
        tzolkin.put(4, "kan");
        tzolkin.put(5, "chicchan");
        tzolkin.put(6, "cimi");
        tzolkin.put(7, "manik");
        tzolkin.put(8, "lamat");
        tzolkin.put(9, "muluk");
        tzolkin.put(10, "ok");
        tzolkin.put(11, "chuen");
        tzolkin.put(12, "eb");
        tzolkin.put(13, "ben");
        tzolkin.put(14, "ix");
        tzolkin.put(15, "mem");
        tzolkin.put(16, "cib");
        tzolkin.put(17, "caban");
        tzolkin.put(18, "eznab");
        tzolkin.put(19, "canac");
        tzolkin.put(20, "ahau");

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int num = scanner.nextInt();
            System.out.println(num);
            while (num-- > 0) {
                int day = Integer.parseInt(scanner.next().replace(".", ""));
                int month = haab.get(scanner.next());
                int year = scanner.nextInt();
                int tmp = 365 * year + month * 20 + day + 1;

                int t_year = (tmp - 1) / 260;
                int t_month = (tmp % 260) % 13;
                if (t_month == 0) {
                    t_month = 13;
                }
                int t_day = (tmp % 260) % 20;
                if (t_day == 0) {
                    t_day = 20;
                }
                System.out.println(t_month + " " + tzolkin.get(t_day) + " " + t_year);
            }
        }
        scanner.close();
    }
}