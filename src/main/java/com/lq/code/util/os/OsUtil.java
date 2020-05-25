package com.lq.code.util.os;

import com.lq.code.util.os.mode.OsInfo;
import org.hyperic.sigar.OperatingSystem;

import java.util.Properties;

/** 获取计算机操作系统信息
 * @author qi
 */
public class OsUtil {
    static Properties properties = System.getProperties();


//
//      public OsUtil(OperatingSystem os){
//          this.os = os;
//
//      }
//
//    /**
//     *  操作系统
//     */
//    public static String getArch(){
//        return os.getArch();
//    }
//
//    /**
//     *
//     */
//    public static String getCpuEndian(){
//        return os.getCpuEndian();
//    }
//
//    public static String getDateModel(){
//
//        return os.getDataModel();
//    }

    public static OsInfo getInfo(){
        OsInfo osInfo = new OsInfo();
        osInfo.setOsVersion(properties.getProperty("os.version"));
        osInfo.setOsName(properties.getProperty("os.name"));
        osInfo.setArch(properties.getProperty("os.arch"));
        return osInfo;
    }

    public static void main(String[] args) {
        OperatingSystem os = OperatingSystem.getInstance();

//        System.out.println(os.getArch());
        System.out.println(os.getCpuEndian());
        System.out.println(os.getDataModel());
    }


}
