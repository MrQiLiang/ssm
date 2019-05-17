package com.lq.code.util;

/**
 * 转型操作工具
 */
public class CastUtil {


    /**
     *  对象类型转字符串类型
     * @param obj  对象
     * @return
     */
    public static String castString(Object obj){

        return castString(obj,"");
    }

    /**
     * 对象类型转字符串类型
     * @param obj 对象
     * @param defaultValue 默认值
     * @return
     */
    public static String castString(Object obj,String defaultValue){

        return obj !=null  ? String.valueOf(obj):defaultValue;
    }

    /**
     *  对象类型转 double
     * @param obj
     * @return
     */
    public static double castDouble(Object obj){

        return castDouble(obj, (double) 0);
    }

    /**
     * 对象类型转 double
     * @param obj
     * @param defaultValue
     * @return
     */
    public static double castDouble(Object obj,Double defaultValue){
        double value = defaultValue;
        if (obj!=null){
            String strValue = castString(obj);
            if (StringUtil.isNotNull(strValue)){
                value = Double.parseDouble(strValue);
            }
        }
        return value;
    }

    /**
     *  对象类型转 int
     * @param obj
     * @return
     */
    public static int castInt(Object obj){

        return castInt(obj,0);
    }

    /**
     * 对象类型转 int
     * @param obj
     * @param defaultValue
     * @return
     */
    public static int castInt(Object obj,Integer defaultValue){
        int value = defaultValue;
        if (obj!=null){
            String strValue = castString(obj);
            if (StringUtil.isNotNull(strValue)){
                value = Integer.parseInt(strValue);
            }
        }
        return value;
    }

    /**
     * 对象类型转布尔
     * @param obj
     * @return
     */
    public static boolean castBoolean(Object obj){

        return castBoolean(obj,false);
    }

    /**
     * 对象类型转布尔
     * @param obj
     * @param defaultValue
     * @return
     */
    public static boolean castBoolean(Object obj,Boolean defaultValue){
        boolean valule = defaultValue;
        if (obj!=null){
            String strValue = castString(obj);
            if (StringUtil.isNotNull(strValue)){
                valule = Boolean.parseBoolean(strValue);
            }
        }
        return valule;
    }

    /**
     *  对象类型装整型(长整型)
     * @param obj
     * @return
     */
    public static long castLong(Object obj){

        return castLong(obj,0L);
    }

    /**
     * 对象类型装整型(长整型)
     * @param obj
     * @param defaultVaule
     * @return
     */
    public static long castLong(Object obj,Long defaultVaule){
        long value = defaultVaule;
        if (obj!=null){
            String strValue = castString(obj);
            if (StringUtil.isNotNull(strValue)){
                value = Long.parseLong(strValue);
            }
        }
        return value;
    }








}
