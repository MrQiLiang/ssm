package com.lq.code.util;


import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author qi
 * 日期辅佐工具类
 */
public class DateUtil {

    /**
     * 默认转换日期格式
     */
    public static final String DEFAULT_PATTERN="yyyy-MM-dd HH:mm:ss";

    /**
     *  返回日期 的字符串 默认格式:yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String getDateToStr(Date date){

        return getDateToStr(date,DEFAULT_PATTERN);
    }

    /**
     *  返回日期的字符串
      * @param date     日期
     * @param pattern   格式 default:yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getDateToStr(Date date,String pattern){
        String str=null;
        if (StringUtil.isNull(pattern)){
            pattern = DEFAULT_PATTERN;
        }
        if (date != null){
            SimpleDateFormat sdf=new SimpleDateFormat(pattern);
            str=sdf.format(date);
        }

        return str;
    }

    /**
     * 日期字符串(String)转换日期对象(Date)
     * @param strDate 日期字符串(默认格式为：yyyy-MM-dd HH:mm:ss)
     * @return 日期对象
     * @throws ParseException
     */
    public static Date strToDate(String strDate) throws ParseException {

        return strToDate(strDate,DEFAULT_PATTERN);
    }


    /**
     *  日期字符串(String)转换日期对象(Date)
     * @param strDate 日期字符串
     * @param pattern 日期格式 (default:yyyy-MM-dd HH:mm:ss)
     * @return  日期对象
     * @throws ParseException
     */
    public static Date strToDate(String strDate,String pattern) throws ParseException {
        if (StringUtil.isNull(pattern)){
                pattern = DEFAULT_PATTERN;
        }

        SimpleDateFormat sdf=new SimpleDateFormat(pattern);

        return sdf.parse(strDate);
    }

    /**
     *  计算出两个date对象相差多少日
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return  相差日（int）
     */
    public static int disparityDay(Date startDate,Date endDate){
        int day = (int)(endDate.getTime()-startDate.getTime())/(24*60*60*1000);
        return day;
    }

    /**
     *  毫秒数转日期字符串
     * @param timeLong 毫秒数
     * @return 日期字符串
     */
    public static String dataFormat(Long timeLong){
        Long secondLong = timeLong/1000;
        Long  millisecond = timeLong%1000;
        Long second = secondLong%60;
        Long minuteLong =  secondLong/60;
        Long minute = second%60;
        Long hour =  minuteLong/60;
        DecimalFormat df = new DecimalFormat("00");
        return df.format(hour)+":"+df.format(minute)+":"+df.format(second);

    }



}


