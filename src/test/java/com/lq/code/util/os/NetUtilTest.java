package com.lq.code.util.os;

import org.junit.Test;

import static org.junit.Assert.*;

public class NetUtilTest {

    @Test
    public void getIP() {
        String serverIp = NetUtil.getIP();
        System.out.println(serverIp);
    }

    @Test
    public void getLocalIpAddr() {
        String serverIp = NetUtil.getLocalIpAddr();
        System.out.println(serverIp);
    }
}