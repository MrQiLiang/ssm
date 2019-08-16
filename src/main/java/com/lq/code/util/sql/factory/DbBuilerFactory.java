package com.lq.code.util.sql.factory;

import com.lq.code.util.sql.AbstractDbBuiler;

/**
 * Sql 工厂
 * @author qi
 */
public interface DbBuilerFactory {

    AbstractDbBuiler getSqlBuilder(String dbType);
}
