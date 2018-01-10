package com.jzw.book.util;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/5 18:02
 */
public class IntegerUtil {

    /**
     * 不为null 也 不为0
     * @param integer
     * @return
     */
    public static boolean isNotNull(Integer integer){
        return null != integer && 0 != integer;
    }


}
