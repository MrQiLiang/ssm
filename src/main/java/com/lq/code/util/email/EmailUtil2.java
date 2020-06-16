package com.lq.code.util.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 邮箱工具类
 * @author qi
 */
public class EmailUtil2 {

    public static void sendEmail(String emaill,String emailMsg) throws MessagingException {

        //创建一个程序与邮件服务器的会话对象session
        Properties props=new Properties();
        props.setProperty("mail.transport.protocol","SMTP");
        props.setProperty("mail.smtp.host","smtp.163.com");
        props.setProperty("mail.smtp.port","25");
        //指定验证为true
        props.setProperty("mail.smtp.auth","true");
        props.setProperty("mail.smtp.timeout","1000");
        //验证账号及密码，账号需要第三方授权

        Authenticator authenticator=new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("qi_liang_gz@163.com","a970209468");
            }
        };

        Session session = Session.getInstance(props,authenticator);

        Message message = new MimeMessage(session);
        //设置发送者
        message.setFrom(new InternetAddress("qi_liang_gz@163.com"));
        //设置放松方式与接受者
        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(emaill));


        message.setContent(emailMsg,"text/html;charset=utf-8");

        message.setSubject("发送邮件测试");

        Transport.send(message);
    }

    public static void main(String[] args) {
        try {
            sendEmail("565391376@qq.com","test");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
