package com.lq.code.util;

import redis.clients.jedis.Jedis;

/**
 * Created by qi_liang on 2018/8/31.
 */
public class RedisUtil {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.99.135",6379);
        jedis.set("user","qi_liang");
        System.out.println("连接成功");
        System.out.println("服务正在运行:"+jedis.ping());
        System.out.println(jedis.get("user"));

    }
}
