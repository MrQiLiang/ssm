package com.lq.code.executor.processor;

import com.lq.code.dto.QueueDto;
import com.lq.code.util.BeanUtil;
import com.lq.code.util.jdbc.JdbcUtils;
import com.lq.code.util.sql.AbstractDbBuiler;
import com.lq.code.util.sql.SqlConstant;
import com.lq.code.util.sql.factory.DbBuilerFactory;
import com.lq.code.util.sql.factory.impl.DefaultDbBuilerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * 扫描实体类自动同步表结构类
 * @author qi
 */
public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {

    private String packagePath ;

    private boolean isUpdateDB;

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public boolean isUpdateDB() {
        return isUpdateDB;
    }

    public void setUpdateDB(boolean updateDB) {
        isUpdateDB = updateDB;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(contextRefreshedEvent.getApplicationContext().getParent() == null){
            //root application context 没有parent，他就是老大.
            //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
            //扫描实体类
            if (isUpdateDB) {
                Set<Class> set = BeanUtil.getClassSet(packagePath);
                DbBuilerFactory dbBuilerFactory = new DefaultDbBuilerFactory();
                AbstractDbBuiler dbBuiler = dbBuilerFactory.getSqlBuilder(SqlConstant.DB_TYPE_MYSQL);
                String sql = dbBuiler.automaticUpdateDb(set);
                JdbcUtils.createTable(sql);
            }
        }
    }


}
