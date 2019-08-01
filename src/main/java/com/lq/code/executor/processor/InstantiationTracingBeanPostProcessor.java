package com.lq.code.executor.processor;

import com.lq.code.dto.QueueDto;
import com.lq.code.util.BeanUtil;
import com.lq.code.util.jdbc.JdbcUtils;
import com.lq.code.util.sql.AbstractDbBuiler;
import com.lq.code.util.sql.MysqlBuilder;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Set;

/**
 * Created by qi_liang on 2018/6/1.
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
                long startTime = System.currentTimeMillis();
                Set<Class> set = BeanUtil.getClassSet(packagePath);
                QueueDto<Class> queueDto = BeanUtil.getQueueDto(packagePath);
                AbstractDbBuiler dbBuiler = new MysqlBuilder();
//                String sql = dbBuiler.automaticUpdateDbNew(queueDto);
                String sql = dbBuiler.automaticUpdateDb(set);
                JdbcUtils.createTable(sql);
                System.out.println("=========实体同步数据结构===========");
                System.out.println(System.currentTimeMillis()-startTime+"毫秒");
            }
        }
    }

}
