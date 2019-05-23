package com.lq.code.util;

import com.lq.code.util.mybatisPlus.xml.SqlMapperXmlDtl;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * xml 工具类
 */
public class XmlUtil {

    public static final String DEFAULT_ENCODING = "utf8";

    /**
     *  object 转 xml 文档
     * @param obj
     * @return
     */
    public static String objToXml(Object obj){
        XStream xstream = new XStream(new DomDriver("utf8"));
        xstream.processAnnotations(obj.getClass()); // 识别obj类中的注解
        /*
         // 以压缩的方式输出XML
         StringWriter sw = new StringWriter();
         xstream.marshal(obj, new CompactWriter(sw));
         return sw.toString();
         */
        // 以格式化的方式输出XML
        return xstream.toXML(obj);

    }

//    public static String objToXml(Writer writer,Object obj) throws UnsupportedEncodingException {
//        XStream xstream = new XStream(new DomDriver("utf8"));
//        xstream.processAnnotations(obj.getClass()); // 识别obj类中的注解
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//        writer = new OutputStreamWriter(outputStream, "UTF-8");
//
//        xstream.toXML(obj, writer);
//        String xml = outputStream.toString("UTF-8");
//        return xml;
//    }

    public static String objToXml(Object obj,String str) throws IOException {
        XStream xstream = new XStream(new DomDriver("utf8"));
        xstream.processAnnotations(obj.getClass()); // 识别obj类中的注解
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(str);
        xstream.toXML(obj, writer);
        String xml = outputStream.toString("UTF-8");
        return xml;
    }

    public static void main(String[] args) {

        SqlMapperXmlDtl sqlMapperXmlDtl = new SqlMapperXmlDtl();
        sqlMapperXmlDtl.setId("findOne");
        sqlMapperXmlDtl.setVale("select * from sys_id ");

        String xmlStr= objToXml(sqlMapperXmlDtl);
        System.out.println(xmlStr);

    }

}
