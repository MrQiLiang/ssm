package com.lq.code.util.os;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.UnknownHostException;

/** 获取计算机网络信息
 * Created by qi_liang on 2018/6/9.
 */
public class NetUtil {

    public static String getIP(){
        String ip = null;
        try {
            InetAddress address = InetAddress.getLocalHost();
            ip = address.getHostAddress();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return  ip;
    }

    public static void main(String[] args) {

        String ip = getIP();
        System.out.println(ip);
    }
}
