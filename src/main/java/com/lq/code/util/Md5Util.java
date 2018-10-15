package com.lq.code.util;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by qi on 2017/8/12.
 */
public class Md5Util {


    /**
     *  md5加密
     * @param plainText
     * @return
     */
  public static String getMd5(String plainText){
    try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(plainText.getBytes());
        byte b[]=md.digest();
        int i;
        StringBuffer buffer=new StringBuffer("");
        for (int offset=0;offset<b.length;offset++){
            i=b[offset];
            if (i<0)
                i+=256;
            if (i<16)
                buffer.append("0");
            buffer.append(Integer.toHexString(i));
        }
        return  buffer.toString();
    }catch (Exception e){
        e.printStackTrace();
    }
    return  null;
    }

    public static void main(String[] args) {
        System.out.println(Md5Util.getMd5("123"));
  }

}
