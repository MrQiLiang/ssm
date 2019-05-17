/**
 * 微信公众平台开发模式
 *
 */
package com.lq.code.util;


import org.apache.log4j.Logger;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Map.Entry;


/**
 * https 请求 微信为https的请求
 *
 * @author
 */
public class HttpKit {

    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final Logger LOGGER = Logger.getLogger(HttpKit.class);

    /**
     * 发送Get请求
     *
     * @param url
     * @return
     */
    public static String get(String url) {
        System.setProperty("jsse.enableSNIExtension", "false");
        //系统属性“https.protocols”来指定SSL客户端使用的协议
        System.setProperty("https.protocols", "TLSv1");

        StringBuffer bufferRes = null;
        try {
            TrustManager[] tm = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象  
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL urlGet = new URL(url);
            HttpsURLConnection http = (HttpsURLConnection) urlGet.openConnection();
            // 连接超时
            http.setConnectTimeout(25000);
            // 读取超时 --服务器响应比较慢，增大时间
            http.setReadTimeout(25000);
            http.setRequestMethod("GET");
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            http.setSSLSocketFactory(ssf);
            http.setDoOutput(true);
            http.setDoInput(true);
            http.connect();

            InputStream in = http.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in, DEFAULT_CHARSET));
            String valueString = null;
            bufferRes = new StringBuffer();
            while ((valueString = read.readLine()) != null) {
                bufferRes.append(valueString);
            }
            in.close();
            if (http != null) {
                // 关闭连接
                http.disconnect();
            }
            return bufferRes.toString();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(url, e);
            return null;
        }
    }

    /**
     * 发送Get请求
     *
     * @param url
     * @param params
     * @return
     */
    public static String get(String url, Map<String, String> params) {
        return get(initParams(url, params));
    }

    /**
     * 发送Post请求
     *
     * @param url
     * @param params
     * @return
     */
    public static String post(String url, String params) {
        System.setProperty("jsse.enableSNIExtension", "false");

        //系统属性“https.protocols”来指定SSL客户端使用的协议
        System.setProperty("https.protocols", "TLSv1");

        StringBuffer bufferRes = null;
        try {
            TrustManager[] tm = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象  
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL urlGet = new URL(url);
            HttpsURLConnection http = (HttpsURLConnection) urlGet.openConnection();
            // 连接超时
            http.setConnectTimeout(25000);
            // 读取超时 --服务器响应比较慢，增大时间
            http.setReadTimeout(25000);
            http.setRequestMethod("POST");
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            http.setSSLSocketFactory(ssf);
            http.setDoOutput(true);
            http.setDoInput(true);
            http.connect();
            OutputStream out = http.getOutputStream();
            out.write(params.getBytes("UTF-8"));
            out.flush();
            out.close();

            InputStream in = http.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in, DEFAULT_CHARSET));
            String valueString = null;
            bufferRes = new StringBuffer();
            while ((valueString = read.readLine()) != null) {
                bufferRes.append(valueString);
            }
            in.close();
            if (http != null) {
                // 关闭连接
                http.disconnect();
            }
            return bufferRes.toString();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(url, e);
            return null;
        }
    }

    /**
     * @param url
     * @param params
     * @return
     */
    private static String initParams(String url, Map<String, String> params) {
        if (null == params || params.isEmpty()) {
            return url;
        }
        StringBuilder sb = new StringBuilder(url);
        if (url.indexOf("?") == -1) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        boolean first = true;
        for (Entry<String, String> entry : params.entrySet()) {
            if (first) {
                first = false;
            } else {
                sb.append("&");
            }
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key).append("=");
            if (StringUtil.isNotNull(value)) {
                try {
                    sb.append(URLEncoder.encode(value, DEFAULT_CHARSET));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    LOGGER.error(url, e);
                }
            }
        }
        return sb.toString();
    }
}

/**
 * 证书管理
 */
class MyX509TrustManager implements X509TrustManager {
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
    }
    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
    }
}