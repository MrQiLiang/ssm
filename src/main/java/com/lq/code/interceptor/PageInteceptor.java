package com.lq.code.interceptor;

import com.lq.cms.vo.BasePageVo;
import com.lq.code.util.StringUtil;
import com.lq.code.util.sql.AbstractDbBuiler;
import com.lq.code.util.sql.MysqlBuilder;
import com.lq.code.util.sql.OracleBuiler;
import com.lq.code.util.sql.PageInterface;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import javax.xml.bind.PropertyException;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by qi_liang on 2018/2/16.
 */
//注解拦截器并签名
//@Signature 拦截的类签名 type 拦截的类  method 类里面的方法  args方法里面的参数
//StatementHandler:数据库会话器，专门用于处理数据库会话,statement的执行操作，是一个接口；
//metaObject：mybatis工具类，可以有效的读取或修改一些重要对象的属性
@Intercepts({@Signature(type = Executor.class,method = "query",args = {MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class}),
@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class})
})
public class PageInteceptor implements Interceptor {

    //数据库类型
    private static String dialect;
    //需要拦截的sqlID
    private static String pageSqlId;



    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (invocation.getTarget() instanceof StatementHandler){
            StatementHandler statementHandler=(StatementHandler)invocation.getTarget();
            MetaObject metaStatementHandler= SystemMetaObject.forObject(statementHandler);
            //通过MetaObject.getValue()获取对象的属性和设置对象的属性
            MappedStatement mappedStatement=(MappedStatement)metaStatementHandler.getValue("delegate.mappedStatement");

            String selectId=mappedStatement.getId();
            if (selectId.matches(pageSqlId)){
                BoundSql boundSql=(BoundSql)metaStatementHandler.getValue("delegate.boundSql");
                String sql=boundSql.getSql();
                PageInterface pageInterface=(PageInterface)boundSql.getParameterObject();
                AbstractDbBuiler db = null;
                if (dialect.equals("mysql")){
                       db = new MysqlBuilder();
                }
                if (dialect.equals("oracle")){
                     db = new OracleBuiler();
                }
                String countSql= db.countSql(sql);
                String pageSql=db.concatPageSql(sql,pageInterface);
                metaStatementHandler.setValue("delegate.boundSql.sql",pageSql);

            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {

        if (target instanceof StatementHandler){
            return Plugin.wrap(target,this);
        }
        else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

        dialect=(String)properties.get("dialect");
        if (StringUtil.isNull(dialect)){
            try {
                throw new PropertyException("dialect property is not found!");
            } catch (PropertyException e) {
                e.printStackTrace();
            }
        }

        pageSqlId= (String) properties.get("pageSqlId");
        if (StringUtil.isNull(pageSqlId)){
            try {
                throw new PropertyException("pageSqlId property is not found!");
            } catch (PropertyException e) {
                e.printStackTrace();
            }
        }
    }


}
