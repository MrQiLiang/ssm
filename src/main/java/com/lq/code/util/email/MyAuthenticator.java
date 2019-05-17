package com.lq.code.util.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Created by qi on 2017/9/8.
 */
public class MyAuthenticator extends Authenticator {

    String userName="";
    String password="";
    public MyAuthenticator(){

    }
    public MyAuthenticator(String userName,String password){
        this.userName=userName;
        this.password=password;
    }
    @Override
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(userName, password);
    }


}
