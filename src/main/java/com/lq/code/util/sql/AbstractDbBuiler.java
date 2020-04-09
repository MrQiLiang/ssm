package com.lq.code.util.sql;

import com.lq.code.dto.QueueDto;

import java.util.Set;

/**
 * @author qi
 * Sql 生成构造器.
 */
public abstract class AbstractDbBuiler {

    /**
     * 括号
     */
    public static final String BRACKETS = ")";

    /**
     *  自动同步表结构
     * @param classSet
     * @return
     */
    abstract public String automaticUpdateDb(Set<Class> classSet);

    /**
     * 自动同步表结构（多线程）
     * @param classQueueDto
     * @return
     */
    abstract public String automaticUpdateDbNew(QueueDto<Class> classQueueDto);

    /**
     *   构建分页sql语句
     * @param sql
     * @param pageInterface
     * @return
     */
     abstract public String concatPageSql(String sql, PageInterface pageInterface);

    /**
     * 构建创建表的sql语句
     * @param clazz
     * @return
     */
    abstract public String createTableStr(Class clazz);

    /**
     *  构建统计sql语句
     * @param sql
     * @return
     */
    public String countSql(String sql){
        StringBuffer sb=new StringBuffer("SELECT COUNT(*) FROM ");
        //SQL 转成大写适
        String upperCaseSql = sql.toUpperCase();
        //统计SQL排除排序SQL代码
        if (sql.lastIndexOf(SqlConstant.ORDER_SQL)>sql.lastIndexOf(BRACKETS)){
            sb.append(sql.substring(upperCaseSql.indexOf(SqlConstant.FROM_SQL)+SqlConstant.FROM_SQL.length(),upperCaseSql.lastIndexOf(SqlConstant.ORDER_SQL)));
        }else{
            sb.append(sql.substring(upperCaseSql.indexOf(SqlConstant.FROM_SQL)+SqlConstant.FROM_SQL.length()));
        }
        return sb.toString();
    }

}
