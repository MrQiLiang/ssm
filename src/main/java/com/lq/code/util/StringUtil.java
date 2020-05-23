package com.lq.code.util;


import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * string工具类
 * @author qi
 */
public class StringUtil {

    /**
     *  判断两个字符串是否相等
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isEqual(String str1,String str2){
      if (isNull(str1)||isNull(str2)){
          return  false;
      }
        return  str1.equals(str2);
    }

    /**
     *   判断字符串为空
     * @param str1
     * @return 为空返回true
     */
    public static boolean isNull(String str1){

        if (str1==null){
             return true;
        }
        if (str1==""||"".equals(str1)){
            return true;
        }
        return false;
    }

    /**
     *  判断字符串不为空
     * @param str1
     * @return 不为空 返回true
     */
    public  static boolean isNotNull(String str1){

        return !isNull(str1);
    }

    /**
     *   随机产生char
     *
     * @param startInt 在ASCII（十进制）开始的位置
     * @param range 随机数的范围
     * @return
     */
    public static char  randomChar(int startInt,int range){
      //  Random random=new Random();
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        int randomNum=threadLocalRandom.nextInt(range-1);
        int randomInt=randomNum+startInt;
        return (char)randomInt ;
    }

    public static String randomString(int length){
        StringBuffer randomString=new StringBuffer();
        while (length>0){
            Random random=new Random();
            int ran=random.nextInt(3);
            switch (ran){
                case 0:randomString.append(random.nextInt(10));break;
                case 1:randomString.append(randomLowerCase());break;
                case 2:randomString.append(randomUpperCase());break;
                default: break;
            }
            length--;
        }
        return randomString.toString();
    }

    /**
     *   随机小写字母
     * @return
     */
    public static char randomLowerCase(){
        return randomChar((int)'a',26);
    }

    /**
     *  随机大写字母
     * @return
     */
    public  static char randomUpperCase(){
        return randomChar((int)'A',26);
    }

    public String randomString(int length,String needRule){

//        Random random=new Random();
        //jdk 1.7 以后用来取代Random,性能会有提升
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        threadLocalRandom.nextInt(100);
        char a1='a';
        int i=a1;

        System.out.println(i);

        return  null;
    }


}
