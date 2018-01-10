package com.jzw.book.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 返回当前时间的字符串
     * 格式 yyyyMMddHHmmss
     * @return
     */
    public static String dateToString(){
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    /**
     * 将一个日期转换成一个规定的日期字符串
     * @param date
     * @return
     */
    public static String dateToString(Date date){
        return sdf.format(date);
    }

}
