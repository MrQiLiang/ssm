package com.lq.code.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HttpsClient {

	private static final Logger LOGGER  = LoggerFactory.getLogger(HttpsClient.class);


	public static String post(String url,Map<String, Object> params) throws IOException{
		String boundary = getBoundaryStr();
		CloseableHttpResponse reponse =null;
		CloseableHttpClient client = null;
		String resultStr = "";
		try{
		   // 获得utf-8编码的mbuilder  
        MultipartEntityBuilder mBuilder = get_COMPATIBLE_Builder("UTF-8",boundary);
        /** 
         * 原生的微信使用的url是https://api.weixin.qq.com/cgi-bin/media/upload? 
         * access_token=##ACCESS_TOKEN##&type=##TYPE## 
         * 一般都会使用这个把参数直接携带在url中。我个人不喜欢这样，因为既然使用了httpclient，完全可以把参数 
         * 设置在我们的body体中。所以我们使用的url是这样的 
         * https://api.weixin.qq.com/cgi-bin/media/upload 然后通过在body体中设置参数来设置 
         * access_token和type这两个字段 
         *  
         * */
        for(String key:params.keySet()){
        	
        	Class clazz = params.get(key).getClass();
        	String objectType = clazz.getName();
        	if("java.io.File".equals(objectType)){
        		 // 这里就是我要上传到服务器的多媒体图片  
               File file =(File)params.get(key);
               mBuilder.addBinaryBody(key,file,  
        	                ContentType.APPLICATION_OCTET_STREAM,file 
        	                        .getName());  
        	}
        	if("java.lang.String".equals(objectType)){
        		 String value =(String)params.get(key);
        		 mBuilder.addTextBody(key, value);
        	}
        }
        // 建造我们的http多媒体对象  
        HttpEntity he = mBuilder.build();  
        // 建立一个sslcontext，这里我们信任任何的证书。  
        SSLContext context = getTrustAllSSLContext();  
        // 建立socket工厂  
        SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(  
                context);  
        // 建立连接器  
       client = HttpClients.custom()  
                .setSSLSocketFactory(factory).build();  
            // 得到一个post请求的实体  
            HttpPost post = getMultipartPost(url, boundary);  
            // 给请求添加参数  
            post.setEntity(he);  
            // 执行请求并获得结果  
           reponse = client.execute(post);  
                // 获得返回的内容  
            HttpEntity entity = reponse.getEntity();  
                // 输出  
            System.out.println(JSONObject.toJSONString(entity));  

            resultStr =  JSONObject.toJSONString(entity);

			Reader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
			String line = null;
			StringBuffer buffer = new StringBuffer();
			while (reader.ready()){
				buffer.append((char)reader.read());
			}
			System.out.println(buffer.toString());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			  // 关闭返回的reponse
			if(reponse!=null){
				reponse.close();
			}
			if(client!=null){
			 // 关闭client  
			client.close();
			}
		}
		return resultStr;
	}
	
	private static String getBoundaryStr() {
		String boundary = UUID.randomUUID().toString().replace("-", "");
	    return boundary;  
	}  
	  
	  
	private static MultipartEntityBuilder get_COMPATIBLE_Builder(String charSet,String boundarStr) {
	    MultipartEntityBuilder result = MultipartEntityBuilder.create();  
	    result.setBoundary(boundarStr)  
	            .setCharset(Charset.forName(charSet))  
	            .setMode(HttpMultipartMode.BROWSER_COMPATIBLE);  
	    return result;  
	}  
	  
	
	private static HttpPost getMultipartPost(String url,String boundarStr) {  
	    /* 这里设置一些post的头部信息，具体求百度吧 */  
	    HttpPost post = new HttpPost(url);  
	    post.addHeader("Connection", "keep-alive");  
	    post.addHeader("Accept", "*/*");  
	    post.addHeader("Content-Type", "multipart/form-data;boundary="  
	            + boundarStr);  
	    post.addHeader("User-Agent",  
	            "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");  
	    return post;  
	}
	
	private static SSLContext getTrustAllSSLContext() throws Exception {  
//	    SSLContext context = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
//
//			@Override
//			public boolean isTrusted(X509Certificate[] arg0, String arg1)
//					throws java.security.cert.CertificateException {
//				// 这一句就是信任任何的证书，当然你也可以去验证服务器的真实性
//				return true;
//			}
//		}).build();
		SSLContext context = SSLContext.getDefault();
	    return context;  
	}
	
	public static void main(String[] args) throws IOException {
		File file =new File("/Users/qi_liang/Downloads/timg.jpeg");
		String url = "https://api.weixin.qq.com/cgi-bin/media/upload";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("access_token", "10_0oKKCsF9JL30JeGZDyfNWDhiaRvivAL9vs9ihvaledzBuPVM6IMvwcFUc58AFwlETRdvEBAFXOYbF2GoKmbtMmopCs78m9UE8whgrYU4kJww4mSooMcq8el-qnU4JdjPGKruZLjdNS246hXyWOHbAAAHZS");
		params.put("type", "image");
		if(file.exists()){
			params.put("media", file);
		}
		String resultStr = post(url,params);
		System.out.println(resultStr);
	}
	  
}
