package com.lq.code.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * http工具类
 * @author qi
 */
public class HttpUtil {

    public static String sendGet(String url,String param){
        StringBuffer result=new StringBuffer();
        BufferedReader in=null;
        try {
            String urlNameString=url+"?"+param;
            URL reaulUrl=new URL(urlNameString);
            URLConnection connection=reaulUrl.openConnection();
            // 设置通用的请求属性

            connection.setRequestProperty(" ", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            //
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //开启实际链接
            connection.connect();
            //获取所有响应头字段
            Map<String,List<String>> map=connection.getHeaderFields();
            //遍历所有的响应头字段
            for (String key:map.keySet()){
                System.out.println(key+"-------------->"+map.get(key));
            }
            in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line=in.readLine())!=null){
               result.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (in!=null){
                    in.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }

        return  result.toString();
    }

    public static void main(String[] args) {
      String urlName="https://www.baidu.com";
      String result=HttpUtil.sendGet(urlName,"a=1");
        System.out.println(result);
    }
}
