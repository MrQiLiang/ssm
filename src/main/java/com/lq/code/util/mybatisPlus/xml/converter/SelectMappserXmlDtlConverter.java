package com.lq.code.util.mybatisPlus.xml.converter;

import com.lq.code.util.mybatisPlus.xml.SelectMappserXmlDtl;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class SelectMappserXmlDtlConverter implements Converter{

    @Override
    public void marshal(Object obj, HierarchicalStreamWriter writer, MarshallingContext marshallingContext) {
        if (obj instanceof SelectMappserXmlDtl){
            SelectMappserXmlDtl selectMappserXmlDtl = (SelectMappserXmlDtl)obj;
            writer.addAttribute("id",selectMappserXmlDtl.getId());
            writer.addAttribute("parameterType",selectMappserXmlDtl.getParameterType());
            writer.addAttribute("resultType",selectMappserXmlDtl.getResultType());
            writer.setValue(selectMappserXmlDtl.getValue());
        }
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext unmarshallingContext) {
        SelectMappserXmlDtl selectMappserXmlDtl = new SelectMappserXmlDtl();
        selectMappserXmlDtl.setId(reader.getAttribute("id"));
        selectMappserXmlDtl.setParameterType(reader.getAttribute("parameterType"));
        selectMappserXmlDtl.setResultType(reader.getAttribute("resultType"));
        selectMappserXmlDtl.setValue(reader.getValue());
        return selectMappserXmlDtl;
    }

    @Override
    public boolean canConvert(Class type) {
        return type.equals(SelectMappserXmlDtl.class);
    }
}
