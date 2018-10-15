package com.lq.wechat.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信公众号素材工具类
 * Created by qi_liang on 2018/5/24.
 */
public class MediaUtil {

    //临时素材上传接口
    private static final String  MEIDA_TEMPORARY_UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";

    /**
     *  上传素材
     * @return
     */
    public static String upLoadMedia(){

        return "";
    }


    public static void main(String[] args) {
        Map<String,Object> params = new HashMap();
        File file = new File("");
        params.put("file",file);
        params.put("accessTokne","测试");

        for (String key:params.keySet()){
            Class clazz = params.get(key).getClass();
            System.out.println(clazz.getName());
        }

    }

}
