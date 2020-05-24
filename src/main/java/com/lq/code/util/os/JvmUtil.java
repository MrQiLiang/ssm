package com.lq.code.util.os;

import com.lq.code.util.os.mode.JvmInfo;

import java.text.DecimalFormat;
import java.util.Properties;

/**
 * jvm工具类
 * @author qi
 */
public class JvmUtil {

    static Properties properties = System.getProperties();
    static Runtime runtime = Runtime.getRuntime();

    /**
     *  获取java版本号
     * @return
     */
    public static String getVersion(){

        return properties.getProperty("java.version");
    }

    /**
     *  获取Java 环境供应商名称
     */
    public static String getVendor(){

        return properties.getProperty("java.vendor");
    }

    /**
     *  获取java 环境供应商url
     */
    public static String getVendorUrl(){
        return properties.getProperty("java.vendor.url");
    }

    /**
     *  获取java安装路径
     * @param
     */
    public static String getHome(){

        return properties.getProperty("java.home");
    }

    /**
     *  获取虚拟机可以使用的总内存
     */
    public static Long getTotalMemory(){

        return runtime.totalMemory();
    }
    /**
     * 获取虚拟机可以使用的数据器个数
     */
    private static  Integer getCupNum(){
        return runtime.availableProcessors();
    }
    /**
     * 返回jvm 信息
     */

    public static JvmInfo getInfo(){
        JvmInfo jvmInfo = new JvmInfo();
        jvmInfo.setVersion(getVersion());
        jvmInfo.setCupNum(getCupNum());
        jvmInfo.setTotalMemory(getTotalMemory());
        return jvmInfo;
    }

    /**
     *
      * @param args
     */

    /**
     * Starts the program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new JvmUtil().displayAvailableMemory();
    }

    /**
     * 显示JVM总内存，JVM最大内存和总空闲内存
     */
    public void displayAvailableMemory() {
        DecimalFormat df = new DecimalFormat("0.00") ;

        //显示JVM总内存
        long totalMem = Runtime.getRuntime().totalMemory();
        System.out.println(df.format(totalMem/1024/1024) + " MB");
        //显示JVM尝试使用的最大内存
        long maxMem = Runtime.getRuntime().maxMemory();
        System.out.println(df.format(maxMem ) + " MB");
        //空闲内存
        long freeMem = Runtime.getRuntime().freeMemory();
        System.out.println(df.format(freeMem ) + " MB");
    }

}
