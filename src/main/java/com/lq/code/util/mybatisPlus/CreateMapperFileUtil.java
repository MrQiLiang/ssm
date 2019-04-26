package com.lq.code.util.mybatisPlus;

import com.lq.code.util.FileUtil;
import com.lq.code.util.XmlUtil;
import com.lq.code.util.mybatisPlus.xml.MapperXmlDtl;
import com.lq.code.util.mybatisPlus.xml.SelectMappserXmlDtl;
import com.lq.code.util.mybatisPlus.xml.SqlMapperXmlDtl;
import com.lq.code.util.sql.AbstractDbBuiler;
import com.lq.code.util.sql.MysqlBuilder;
import com.lq.code.util.sql.SqlUtil;
import com.lq.dao.*;
import com.lq.entity.*;
import com.lq.wechat.util.MessageUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by qi_liang on 2018/1/29.
 */
public class CreateMapperFileUtil {

    public static String createXML(String filePath,Class daoClazz,Class entityClazz,AbstractDbBuiler db){
        String result= FileUtil.read(filePath);
        //dao类名
        result=result.replace("@DaoName",daoClazz.getName());
        //实体名
        result=result.replace("@BeanName",entityClazz.getName());
        //表名
        result=result.replace("@tableName", SqlUtil.beanNameToTableName(entityClazz));

        StringBuffer columnBuffer=new StringBuffer();
        StringBuffer attributeBuffer=new StringBuffer();
        StringBuffer columnAndAttributeBuffer=new StringBuffer();
        Map<String,String> map=SqlUtil.getAttributeAndColumn(entityClazz);
        for (String key:map.keySet()){
            attributeBuffer.append("#{"+key+"},");
            columnBuffer.append(map.get(key)+",");
            columnAndAttributeBuffer.append("\n <if test=\""+key+"!=null\">"+map.get(key)+"="+"#{"+key+"},</if>");
        }
        attributeBuffer.deleteCharAt(attributeBuffer.length()-1);
        columnBuffer.deleteCharAt(columnBuffer.length()-1);
        //columnAndAttributeBuffer.deleteCharAt(columnAndAttributeBuffer.length()-1);
        result=result.replace("@tableColumn",columnBuffer);
        result=result.replace("@beanAttribute",attributeBuffer);
        result=result.replace("@ColumnEqAttribute",columnAndAttributeBuffer);
        return  result;

    }

    public static void createXml(Class daoClazz,Class entityClazz,AbstractDbBuiler db)throws IOException {
        String path=System.getProperty("user.dir");
        String filePath=path+"/src/main/resources/mybatis/mappingTemplate.xml";
        String fileName = daoClazz.getSimpleName();

        String xmlFilePath=path+"/src/main/resources/mybatis/mapping/"+fileName+".xml";
        String resultStr = createXML(filePath, daoClazz,entityClazz,db);
        File file=new File(xmlFilePath);
        if (file.exists()){
            file.createNewFile();
        }
        FileUtil.writer(resultStr,xmlFilePath);

    }

    public static void main(String[] args) throws IOException {
        createXml(WechatMessageDao.class,WechatMessage.class,new MysqlBuilder());
    }




}
