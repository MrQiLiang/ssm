package com.lq.code.util.sql;

import com.lq.code.util.BeanUtil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by qi_liang on 2018/6/2.
 */
public class SqlUtil {

    /**
     *  大小写转化驼峰
     * @param str
     * @return
     */
    public  static String caseToHump(String str){
        StringBuffer strBuffer=new StringBuffer();
        char[] charArray=str.toCharArray();
        for (int i=0;i<charArray.length;i++){
            if (i==0){
                strBuffer.append(charArray[i]);
                continue;
            }
            if (Character.isUpperCase(charArray[i])){
                strBuffer.append("_"+charArray[i]);
            }else {
                strBuffer.append(charArray[i]);
            }
        }
        return strBuffer.toString().toLowerCase();
    }

    public static String humpToCase(String str){
        StringBuffer strBuffer=new StringBuffer();
        char[] charArray=str.toCharArray();
        for (int i=0;i<charArray.length;i++){
            if (charArray[i] == '_'){
                i++;
                strBuffer.append(Character.toUpperCase(charArray[i]));
            }else {
                strBuffer.append(Character.toLowerCase(charArray[i]));
            }
        }
        return strBuffer.toString();
    }

    /**
     *   类名转表名
     * @param entityClazz
     * @return
     */
    public  static String beanNameToTableName(Class entityClazz){
        //类名
        //驼峰转换
        String entityName = BeanUtil.getEntityName(entityClazz);
        String tableName=caseToHump(entityName);
        return tableName;
    }

    /**
     * 返回 key为类属性 value为列名的键值对
     * @param entityClazz
     * @return
     */
    public static Map<String,String> getAttributeAndColumn(Class entityClazz){
        Map<String,String> map=new HashMap<>();
        List<Field> fieldsList=BeanUtil.getAllField(entityClazz);
        Iterator iterator = fieldsList.iterator();
        while (iterator.hasNext()){
            Field field = (Field) iterator.next();
            map.put(field.getName(),caseToHump(field.getName()));
        }

        return map;
    }

    public static void main(String[] args) {
        String talbe ="TABLE_CAT";
        String entityName = SqlUtil.humpToCase(talbe);
        System.out.println(entityName);

    }

    /**
     *  对象属性名转换成表列名
     * @param attribute （对象属性）
     * @return  列名
     */
    public  String getColulnmn(String attribute){

        return caseToHump(attribute);
    }
}
