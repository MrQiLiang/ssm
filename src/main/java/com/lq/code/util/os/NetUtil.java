package com.lq.code.util.os;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/** 获取计算机网络信息
 * @author qi
 */
public class NetUtil {

    public static final Logger LOGGER = LoggerFactory.getLogger(NetUtil.class);

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

    public static String getLocalIpAddr(){
        Enumeration<NetworkInterface> networks = null;
        try {
            // 获取网卡设备
            networks = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            LOGGER.info(e.getMessage());
        }
        InetAddress ip = null;
        Enumeration<InetAddress> addrs;
        // 遍历网卡设备
        while (networks.hasMoreElements()){
            addrs = networks.nextElement().getInetAddresses();
            while (addrs.hasMoreElements()){
                ip = addrs.nextElement();
                if (ip != null && ip instanceof InetAddress && ip.isSiteLocalAddress()){
                    if (ip.getHostAddress()==null || "".equals(ip.getHostAddress())){
                        LOGGER.info("获取到的客户端内网ip为空，从配置文件读取本地ip。");
                        return null;
                    }
                    return ip.getHostAddress();// 客户端ip
                }
            }
        }
        return null;
    }

}
