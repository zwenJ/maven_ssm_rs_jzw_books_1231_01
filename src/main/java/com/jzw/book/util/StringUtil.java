package com.jzw.book.util;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * String工具类
 * @author Jzw
 */
public class StringUtil {

    /**
     * 判断字符串不是 NULL 且不是 空字符串
     * @param str
     * @return
     */
    public static boolean isNotNull(String str){

        if (null != str && "" != str){
            return true;
        }

        return false;
    }


    /**
     * 去掉字符串的左右空格，如果字符串是NULL或者是“”则返回“”
     * @param str
     * @return
     */
    public static String trimString(String str){
        if (isNotNull(str)) {
            return str.trim();
        }
        return "";
    }


    /**
     * 是否包含某符号
     * @param str
     * @param sign
     * @return
     */
    public static boolean isSign(String str, String sign){
        if (isNotNull(str)&&isNotNull(sign)){
            return str.contains(sign);
        }
        return false;
    }


    /**
     * 截取后缀
     * @param regex   字符串
     * @param limit   截取开始符（包含）
     * @return
     */
    public static String sub(String regex, String limit){
        if (isSign(regex,limit)) {
            return regex.substring(regex.lastIndexOf(limit),regex.length());
        }
        return "";
    }


}
