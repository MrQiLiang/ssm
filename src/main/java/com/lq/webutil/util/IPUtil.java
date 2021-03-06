package com.lq.webutil.util;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *  ip工具类
 * @author qi
 */
public class IPUtil {

    /**
     * 未知ip
     */
    public static final String IP_UNKNOWM = "unknown";
    /**
     * 操作系统-windows
     */
    public static final String OS_WINDOWS = "windows";
    /**
     * 操作系统-mac
     */
    public static final String OS_MAC = "mac";
    /**
     * 操作系统-linux
     */
    public static final String OS_LINUX = "x11";

    /**
     * 操作系统-android
     */
    public static final String OS_ANDROID = "android";
    /**
     * 操作系统-iphone
     */
    public static final String OS_IPHONE = "iphone";


    public static String getIP(HttpServletRequest request){

        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || IP_UNKNOWM.equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || IP_UNKNOWM.equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || IP_UNKNOWM.equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ?"127.0.0.1":ip;

    }

    public static String getDomain(String domain){
        try {
            String houstAddress=InetAddress.getByName("www.baidu.com").getHostAddress();
            return houstAddress;
        }catch (UnknownHostException e){
            StringBuffer explain=new StringBuffer();
            explain.append("异常常见原因：\n");
            explain.append("1.访问网站已经倒闭/关闭或者不存在,可以在浏览器中验证一下;\n");
            explain.append("2.无法解析该域名，可以将域名对应的ip写入到hosts文件中保存;\n");
            explain.append(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) throws UnknownHostException {
        //获取本机IP地址
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        //获取www.baidu.com的地址
        System.out.println(InetAddress.getByName("www.baidu.com"));
        //获取www.baidu.com的真实IP地址
        System.out.println();
        //获取配置在HOST中的域名IP地址
    //    System.out.println(InetAddress.getByName("TEST").getHostAddress());
    }

    @SuppressWarnings("AlibabaUndefineMagicConstant")
    public String getUserMessage(HttpServletRequest request){
        String  browserDetails  =   request.getHeader("User-Agent");
        String  userAgent       =   browserDetails;
        String  user            =   userAgent.toLowerCase();

        String os = "";
        String browser = "";

        //=================OS Info=======================
        if (userAgent.toLowerCase().indexOf(OS_WINDOWS) >= 0 )
        {
            os = "Windows";
        } else if(userAgent.toLowerCase().indexOf(OS_MAC) >= 0)
        {
            os = "Mac";
        } else if(userAgent.toLowerCase().indexOf(OS_LINUX) >= 0)
        {
            os = "Unix";
        } else if(userAgent.toLowerCase().indexOf(OS_ANDROID) >= 0)
        {
            os = "Android";
        } else if(userAgent.toLowerCase().indexOf(OS_IPHONE) >= 0)
        {
            os = "IPhone";
        }else{
            os = "UnKnown, More-Info: "+userAgent;
        }
        //===============Browser===========================
        //noinspection AlibabaUndefineMagicConstant
        if (user.contains("edge"))
        {
            browser=(userAgent.substring(userAgent.indexOf("Edge")).split(" ")[0]).replace("/", "-");
        } else //noinspection AlibabaUndefineMagicConstant
            if (user.contains("msie"))
        {
            String substring=userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
            browser=substring.split(" ")[0].replace("MSIE", "IE")+"-"+substring.split(" ")[1];
        } else //noinspection AlibabaUndefineMagicConstant,AlibabaUndefineMagicConstant
                if (user.contains("safari") && user.contains("version"))
        {
            browser=(userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0]
                    + "-" +(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
        } else //noinspection AlibabaUndefineMagicConstant,AlibabaUndefineMagicConstant
            if ( user.contains("opr") || user.contains("opera"))
        {
            //noinspection AlibabaUndefineMagicConstant
            if(user.contains("opera")){
                browser=(userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0]
                        +"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
            }else //noinspection AlibabaUndefineMagicConstant
                if(user.contains("opr")){
                browser=((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-"))
                        .replace("OPR", "Opera");
            }

        } else //noinspection AlibabaUndefineMagicConstant
                if (user.contains("chrome"))
        {
            browser=(userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
        } else //noinspection AlibabaUndefineMagicConstant,AlibabaUndefineMagicConstant
                if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1)  ||
                (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) ||
                (user.indexOf("mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1) )
        {
            browser = "Netscape-?";

        } else //noinspection AlibabaUndefineMagicConstant
                    if (user.contains("firefox"))
        {
            browser=(userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
        } else //noinspection AlibabaUndefineMagicConstant
                    if(user.contains("rv"))
        {
            String IEVersion = (userAgent.substring(userAgent.indexOf("rv")).split(" ")[0]).replace("rv:", "-");
            browser="IE" + IEVersion.substring(0,IEVersion.length() - 1);
        } else
        {
            browser = "UnKnown, More-Info: "+userAgent;
        }

        return os +" --- "+ browser ;

}

}
