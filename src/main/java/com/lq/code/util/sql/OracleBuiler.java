package com.lq.code.util.sql;

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
    public String concatPageSql(String sql, PageInterface pageInterface) {
        StringBuffer sb=new StringBuffer("select * from (select t1.*,ROWNUM rm from(");
        sb.append(sql);
        Integer index=(pageInterface.getPage()-1)*pageInterface.getPageSize();
        sb.append(")t1 where rownum<="+(index+pageInterface.getPageSize())+") where rm>"+index);
        return sb.toString();
    }

    @Override
    public String createTableStr(Class clazz) {
        return null;
    }
}
