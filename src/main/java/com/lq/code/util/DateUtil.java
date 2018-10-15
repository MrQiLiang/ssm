package com.lq.code.util;


import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by qi_liang on 2018/1/26.
 */
public class DateUtil {

    public static final String DEFAULT_PATTERN="yyyy-MM-dd HH:mm:ss";

    /**
     *  返回日期 的字符串 默认格式:yyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String getDateToStr(Date date){
        if (date==null){
            throw new NullPointerException("========date 对象为空null======");
        }

        return getDateToStr(date,DEFAULT_PATTERN);
        }

    /**
     *  返回日期的字符串
      * @param date     日期
     * @param pattern   格式 default:yyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getDateToStr(Date date,String pattern){
        String str=null;
        if (StringUtil.isNull(pattern)){
            pattern = DEFAULT_PATTERN;
        }
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        if (date == null){
            throw new NullPointerException("====== date 对象为空 null======");
        }
        str=sdf.format(date);
        return str;
    }


    public static Date strToDate(String strDate,String pattern) throws ParseException {
        if (StringUtil.isNull(pattern)){
                pattern = DEFAULT_PATTERN;
        }

        SimpleDateFormat sdf=new SimpleDateFormat(pattern);

        return sdf.parse(strDate);
    }

    public static  int disparityDay(Date startDate,Date endDate){
        int day = (int)(endDate.getTime()-startDate.getTime())/(24*60*60*1000);
        return day;
    }

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


