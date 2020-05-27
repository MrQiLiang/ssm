package com.lq.code.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 属性文件工具类
 * @author qi
 */
public class PropsUtil {

    private static final Logger logger = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     * @param fileName
     * @return
     */
    public static Properties loadProps(String fileName){
        Properties properties = null;
        InputStream is = null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null){
                 throw  new FileNotFoundException(fileName+" file is not found");
            }
            properties = new Properties();

            properties.load(is);
        } catch (IOException e) {
            logger.error(" load properties file failure",e);
        } finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    logger.error("close input stram failure",e);
                }
            }
        }
        return properties;
    }

    public static String getString(Properties properties,String key){

        return getString(properties,key,"");
    }

    /**
     *  获取字符串类型属性
     * @param properties      配置文件对象
     * @param key             属性key
     * @param defaultValue    属性为空，设置默认值
     * @return
     */
    public static String getString(Properties properties,String key,String defaultValue){
        String value = defaultValue;
        if (properties.containsKey(key)){
            value = properties.getProperty(key);
        }
        return value;
    }

    /**
     *  获取整型属性(默认值:0)
     * @param properties
     * @param key
     * @return
     */
    public static int getInt(Properties properties,String key){

        return getInt(properties,key,0);
    }

    /**
     *  获取整型属性
     * @param properties
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getInt(Properties properties,String key,int defaultValue){
        int value = defaultValue;
        if (properties.containsKey(key)){
            value = CastUtil.castInt(properties.getProperty(key));
        }
        return value;
    }

    /**
     *  获取布尔类型属性（默认值：false）
     * @param properties
     * @param key
     * @return
     */
    public static boolean getBoolean(Properties properties,String key){

        return getBoolean(properties,key,false);
    }

    public static boolean getBoolean(Properties properties,String key,Boolean defaultValue){
        boolean value = defaultValue;
        if (properties.containsKey(key)){
            value = CastUtil.castBoolean(properties.getProperty(key));
        }
        return value;
    }

}
