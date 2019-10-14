package com.lq.jms.service;

/**
 * @author qi
 */
public interface ProductService  {

    /**
     * 发送队列消息
     * @param topic 主题
     * @param msg   消息内容
     */
    void sendQueue(String topic,String msg);


}
