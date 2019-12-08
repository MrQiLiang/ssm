package com.lq.code.util.sql.factory.impl;

import com.lq.code.util.sql.AbstractDbBuiler;
import com.lq.code.util.sql.MysqlBuilder;
import com.lq.code.util.sql.OracleBuiler;
import com.lq.code.util.sql.SqlConstant;
import com.lq.code.util.sql.factory.DbBuilerFactory;

/**
 *  @author qi
 *  dbBuilfer 生产工厂模式默认实现
 */
public class DefaultDbBuilerFactory implements DbBuilerFactory {

    @Override
    public AbstractDbBuiler getSqlBuilder(String dbType) {
        AbstractDbBuiler abstractDbBuiler = null;
        switch (dbType){
            case SqlConstant
                    .DB_TYPE_MYSQL:
                abstractDbBuiler = new MysqlBuilder();
            break;
            case SqlConstant.DB_TYPE_ORACLE:
                abstractDbBuiler = new OracleBuiler();
                break;
           default: abstractDbBuiler = null;
        }
        return abstractDbBuiler;
    }
}
