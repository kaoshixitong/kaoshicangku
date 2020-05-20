package com.yitihua3.exam.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author aiwoqe
 * @Type TypeConverter
 * @Desc
 * @date 2020年04月29日
 * @Version V1.0
 */
public class TypeConverter {
    public static String dateToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH/mm/ss");
        String str = dateFormat.format(date);
        return str;
    }

    public static Date stringToDate(String str)  {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH/mm/ss");
        Date date = null;
        try {
            date = dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String timestampToTimestampString (Timestamp timestamp){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH/mm/ss");
        String str = dateFormat.format(timestamp);
        return str;
    }






}
