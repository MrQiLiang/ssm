package com.lq.wechat.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class MessageUtil {
	

	
	/**
	 *  
	 * @param req
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String, String> xmlToMap(HttpServletRequest req) throws IOException, DocumentException{
		Map<String, String> map=new HashMap<>();
		SAXReader reader=new SAXReader();
		InputStream ins=req.getInputStream();
		String resultString=IoUtil.convertStreamToString(ins);
		System.out.println(resultString);
	//	Document doc=reader.read(ins);
		Document doc=DocumentHelper.parseText(resultString);
		Element root=doc.getRootElement();
		List<Element> list=root.elements();
		for(Element e:list){
			map.put(e.getName(), e.getText());
		}
		ins.close();
		return map;
	}
	
	public static String MessageToXml(Object obj){
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




}
