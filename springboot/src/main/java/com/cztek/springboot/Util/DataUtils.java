package com.cztek.springboot.Util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jboss.jandex.Main;
import org.thymeleaf.util.DateUtils;

public class DataUtils {

    public static String DATE_FORMAT = "yyyy-MM-dd";

    public static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String DATE_FORMAT_CHINESE = "yyyy年M月d日";
    
    public static String DATE_TIME_HOUR= "HH:mm:ss";

    public static Date stringToDate(String datestr) {
        if (datestr == null || datestr.equals("")) {
            return null;
        }
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat(DataUtils.DATE_FORMAT);
        try {
            date = df.parse(datestr);
        } catch (ParseException e) {
            date = new Date();
        }
        return date;
    }
    
    public static Date hourDate(String datestr){
        if (datestr == null || datestr.equals("")) {
            return null;
        }
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat(DataUtils.DATE_TIME_HOUR);
        try {
            date = df.parse(datestr);
        } catch (ParseException e) {
            date = new Date();
        }
        return date;
    }

    public static Date stringToDateByStamp(String datestr, String formatStr) {
        if (datestr == null || datestr.equals("") || datestr.length() < 13) {
            return null;
        }
        SimpleDateFormat df = new SimpleDateFormat(formatStr);
        Long time = new Long(datestr);
        String d = df.format(time);
        Date date = null;
        try {
            date = df.parse(d);
        } catch (ParseException e) {
            date = new Date();
        }
        return date;
    }

    public static String dateToString(Date date) {
        String datestr = null;
        SimpleDateFormat df = new SimpleDateFormat(DataUtils.DATE_FORMAT);
        datestr = df.format(date);
        return datestr;
    }
    
}
