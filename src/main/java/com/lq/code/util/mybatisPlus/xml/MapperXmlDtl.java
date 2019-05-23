package com.lq.code.util.mybatisPlus.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

@XStreamAlias("mapper")
public class MapperXmlDtl {

    @XStreamAsAttribute
    private String namespace;

    @XStreamImplicit
    private List<SqlMapperXmlDtl> sqlMapperXmlDtlList;

    @XStreamImplicit
    private List<SelectMappserXmlDtl> selectMappserXmlDtlList;

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public List<SqlMapperXmlDtl> getSqlMapperXmlDtlList() {
        return sqlMapperXmlDtlList;
    }

    public void setSqlMapperXmlDtlList(List<SqlMapperXmlDtl> sqlMapperXmlDtlList) {
        this.sqlMapperXmlDtlList = sqlMapperXmlDtlList;
    }

    public List<SelectMappserXmlDtl> getSelectMappserXmlDtlList() {
        return selectMappserXmlDtlList;
    }

    public void setSelectMappserXmlDtlList(List<SelectMappserXmlDtl> selectMappserXmlDtlList) {
        this.selectMappserXmlDtlList = selectMappserXmlDtlList;
    }
}
