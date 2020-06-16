package com.lq.code.util.email;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Calendar;
import java.util.Properties;

/**
 * email 工具类
 * @author qi
 */
public class EmailUtil {

    /**
     *  发送邮件消息
     * @param smtpHost          发送地址
     * @param from               账号
     * @param fromUserPassword   密码
     * @param to                  目标邮箱
     * @param subject             主题
     * @param messageText         消息内容
     * @param messageType         消息类型
     * @throws MessagingException
     */
    @SuppressWarnings("static-access")
    public static void sendMessage(String smtpHost, String from,
                                   String fromUserPassword, String to, String subject,
                                   String messageText, String messageType) throws MessagingException {
        // 第一步：配置javax.mail.Session对象
        System.out.println("为" + smtpHost + "配置mail session对象");


        Properties props = new Properties();
        props.put("mail.smtp.host", smtpHost);
        //使用 STARTTLS安全连接
        props.put("mail.smtp.starttls.enable","true");
        //google使用465或587端口
        props.put("mail.smtp.port", "25");
        // 使用验证
        props.put("mail.smtp.auth", "true");
        Session mailSession = Session.getInstance(props,new MyAuthenticator(from,fromUserPassword));

        // 第二步：编写消息
        System.out.println("编写消息from——to:" + from + "——" + to);

        InternetAddress fromAddress = new InternetAddress(from);
        InternetAddress toAddress = new InternetAddress(to);

        MimeMessage message = new MimeMessage(mailSession);

        message.setFrom(fromAddress);
        message.addRecipient(Message.RecipientType.TO, toAddress);

        message.setSentDate(Calendar.getInstance().getTime());
        message.setSubject(subject);
    //    message.setContent(messageText, messageType);

        // 第三步：发送消息
//        Transport transport = mailSession.getTransport("smtp");
//        transport.connect(smtpHost,"chaofeng19861126", fromUserPassword);
//        transport.send(message, message.getRecipients(Message.RecipientType.TO));
//       transport.sendMessage(message,);
        Transport.send(message);
        System.out.println("message yes");
    }


    public static void main(String[] args) {
        try {
            sendMessage("smtp.163.com", "qi_liang_gz@163.com", "a970209468", "wx_qi_liang@163.com", "test", "你好，旧时光", "test");
        }
        catch (MessagingException e){
            e.printStackTrace();
        }
        }

}
