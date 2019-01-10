package com.lq.code.util.mybatisPlus.xml;

import com.lq.code.util.mybatisPlus.xml.converter.SqlMapperXmlDtlConverter;
import com.thoughtworks.xstream.annotations.*;

@XStreamAlias("sql")
@XStreamConverter(SqlMapperXmlDtlConverter.class)
public class SqlMapperXmlDtl {

    private String id;

    private String vale;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVale() {
        return vale;
    }

    public void setVale(String vale) {
        this.vale = vale;
    }
}
