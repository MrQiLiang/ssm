package com.lq.code.util.mybatisPlus.xml.converter;

import com.lq.code.util.mybatisPlus.xml.SqlMapperXmlDtl;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * sql mapper xml转换类
 * @author qi
 */
public class SqlMapperXmlDtlConverter implements Converter{

    /**
     *  对象转 xml
     * @param obj
     * @param writer
     * @param marshallingContext
     */
    @Override
    public void marshal(Object obj, HierarchicalStreamWriter writer, MarshallingContext marshallingContext) {
        if (obj instanceof SqlMapperXmlDtl){
            SqlMapperXmlDtl sqlMapperXmlDtl = (SqlMapperXmlDtl)obj;
            writer.addAttribute("id",sqlMapperXmlDtl.getId());
            writer.setValue(sqlMapperXmlDtl.getVale());
        }

    }

    /**
     *  xml 转 对象
     * @param reader
     * @param unmarshallingContext
     * @return
     */
    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext unmarshallingContext) {
        SqlMapperXmlDtl sqlMapperXmlDtl = new SqlMapperXmlDtl();
        sqlMapperXmlDtl.setId(reader.getAttribute("id"));
        sqlMapperXmlDtl.setVale(reader.getValue());
        return sqlMapperXmlDtl;
    }

    /**
     * 判断转换类型是否正确
     * @param type
     * @return
     */
    @Override
    public boolean canConvert(Class type) {
        return type.equals(SqlMapperXmlDtl.class);
    }
}
