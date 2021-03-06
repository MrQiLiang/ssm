package com.lq.code.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * xml 工具类
 * @author qi
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
        // 识别obj类中的注解
        xstream.processAnnotations(obj.getClass());
        /*
         // 以压缩的方式输出XML
         StringWriter sw = new StringWriter();
         xstream.marshal(obj, new CompactWriter(sw));
         return sw.toString();
         */
        // 以格式化的方式输出XML
        return xstream.toXML(obj);

    }

    public static String objToXml(Object obj,String str) throws IOException {
        XStream xstream = new XStream(new DomDriver("utf8"));
        // 识别obj类中的注解
        xstream.processAnnotations(obj.getClass());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(str);
        xstream.toXML(obj, writer);
        String xml = outputStream.toString("UTF-8");
        return xml;
    }

}
