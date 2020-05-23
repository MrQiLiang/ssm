package com.lq.wechat.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * io工具类
 * @author qi
 */
public class IoUtil {

    public  static String convertStreamToString(InputStream inputStream){
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb=new StringBuilder();

        String line=null;
        try {
            while ((line=reader.readLine())!=null){
                sb.append(line+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return  sb.toString();
    }


}
