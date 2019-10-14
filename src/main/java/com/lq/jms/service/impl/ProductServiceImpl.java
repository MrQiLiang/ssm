package com.lq.jms.service.impl;

import com.lq.jms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @author qi
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private JmsTemplate jmsTemplate;


    @Override
    public void sendQueue(String topic, String msg) {

        jmsTemplate.convertAndSend(topic,msg);
    }


}
