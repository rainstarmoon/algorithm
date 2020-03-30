package com.myproject.algorithm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        List<String> monthBetweenDates = Solution.getMonthBetweenDates("2020-02", "2020-02");
        System.out.println(monthBetweenDates);
    }

    public static List<String> getMonthBetweenDates(String minDate, String maxDate) {
        ArrayList<String> result = new ArrayList<String>();
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        min.setTime(parse(minDate, "yyyy-MM"));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        max.setTime(parse(maxDate, "yyyy-MM"));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(format(curr.getTime(), "yyyy-MM"));
            curr.add(Calendar.MONTH, 1);
        }
        return result;
    }

    public static Date parse(String dateTime, String format) {
        if (dateTime == null || dateTime.length() <= 0) {
            return null;
        }
        String sDateTime = ((dateTime.indexOf('.') > 0)) ? dateTime.substring(0, dateTime.indexOf('.')) : dateTime;
        DateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(sDateTime);
        } catch (ParseException e) {
            return null;
        }
    }


    public static String format(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        if (pattern == null || pattern.equals("")) {
            return date.toString();
        }
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        return formater.format(date);
    }
}

