package com.lq.code.util.mybatisPlus.xml;

import com.lq.code.util.mybatisPlus.xml.converter.SelectMappserXmlDtlConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * @author qi
 */
@XStreamAlias("select")
@XStreamConverter(SelectMappserXmlDtlConverter.class)
public class SelectMappserXmlDtl {

    private String id;

    private String resultType;

    private String parameterType;

    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
