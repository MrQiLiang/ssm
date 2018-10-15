package com.lq.code.util.sql;

import com.lq.cms.vo.BasePageVo;
import com.lq.code.util.BeanUtil;
import com.lq.code.util.jdbc.JdbcUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by qi_liang on 2018/6/2.
 */
public abstract class AbstractDbBuiler {


    abstract public String automaticUpdateDb(Set<Class> classSet);

    /**
     *   构建分页sql语句
     * @param sql
     * @param vo
     * @return
     */
     abstract public String concatPageSql(String sql, BasePageVo vo);

    /**
     *  构建创建表的sql语句
     */
    abstract public String createTableStr(Class clazz);

    /**
     *  构建统计sql语句
     * @param sql
     * @return
     */
    public String countSql(String sql){
        StringBuffer sb=new StringBuffer("select count(*) from ( ");
        sql=sql.toLowerCase();

        if (sql.lastIndexOf("order")>sql.lastIndexOf(")")){
            sb.append(sql.substring(sql.indexOf("from")+4,sql.lastIndexOf("order")));

        }else{
            sb.append(sql.substring(sql.indexOf("from")+4));
        }
        sb.append(")");
        return sb.toString();
    }










}
