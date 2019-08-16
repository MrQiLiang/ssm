package com.lq.code.util.sql.factory;

import com.lq.code.util.sql.AbstractDbBuiler;

/**
 * Sql 构造器工厂
 * 作用：解耦使用者与具体实现类关系
 * @author qi
 */
public interface DbBuilerFactory {

    AbstractDbBuiler getSqlBuilder(String dbType);
}
