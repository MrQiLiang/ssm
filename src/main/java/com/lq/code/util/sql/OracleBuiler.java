package com.lq.code.util.sql;

import com.lq.code.dto.QueueDto;

import java.util.Set;

/**
 * oracle数据库sql构造器
 * @author qi
 */
public class OracleBuiler extends AbstractDbBuiler {


    @Override
    public String automaticUpdateDb(Set<Class> classSet) {
        return null;
    }

    @Override
    public String automaticUpdateDbNew(QueueDto<Class> classQueueDto) {
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
