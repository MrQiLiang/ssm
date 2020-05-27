package com.lq.code.util.mybatis.plus.xml;

import com.lq.code.util.mybatis.plus.xml.converter.SqlMapperXmlDtlConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * sql对象转xml
 * @author qi
 */
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
