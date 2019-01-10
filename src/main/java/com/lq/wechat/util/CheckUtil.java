package com.lq.wechat.util;

import java.util.Arrays;

/**
 *  author qi
 */
public class CheckUtil {

	private static final String TOKEN="qiLiang";
	
	public static boolean checkSingatue(String signature,String timestamp,String nonce){
	
       String []arr=new String[]{TOKEN,timestamp,nonce};
       
       Arrays.sort(arr);
       
       StringBuffer content=new StringBuffer();
       for(int i=0;i<arr.length;i++){
    	   content.append(arr[i]);
       }
       //sha1加密
       String temp=DecriptTest.SHA1(content.toString());
       
       return temp.equals(signature); 
	}


}
