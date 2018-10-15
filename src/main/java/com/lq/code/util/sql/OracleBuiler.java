package com.lq.code.util.sql;

import com.lq.cms.vo.BasePageVo;

import java.util.Set;

/**
 * Created by qi_liang on 2018/6/2.
 */
public class OracleBuiler extends AbstractDbBuiler {


    @Override
    public String automaticUpdateDb(Set<Class> classSet) {
        return null;
    }

    @Override
    public String concatPageSql(String sql, BasePageVo vo) {
        StringBuffer sb=new StringBuffer("select * from (select t1.*,ROWNUM rm from(");
        sb.append(sql);
        Integer index=(vo.getPage()-1)*vo.getRows();
        sb.append(")t1 where rownum<="+(index+vo.getRows())+") where rm>"+index);
        return sb.toString();
    }

    @Override
    public String createTableStr(Class clazz) {
        return null;
    }
}
