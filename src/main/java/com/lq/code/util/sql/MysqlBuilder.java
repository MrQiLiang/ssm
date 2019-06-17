package com.lq.code.util.sql;

import com.lq.code.annotation.Length;
import com.lq.code.dto.QueueDto;
import com.lq.code.util.BeanUtil;
import com.lq.code.util.jdbc.JdbcUtils;
import com.lq.code.util.jdbc.mode.Column;
import com.lq.code.util.jdbc.mode.Table;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by qi_liang on 2018/6/2.
 */
public class MysqlBuilder extends AbstractDbBuiler {

    /**
     *  数据库类型和java类型转换Map
     */
    private static Map<String,String> dataTypeMap=new HashMap<>();

    static {
        dataTypeMap.put("class java.lang.String","varchar");
        dataTypeMap.put("class java.util.Date","datetime");
        dataTypeMap.put("class java.lang.Integer","int");
        dataTypeMap.put("class java.lang.Long","int");
    }


    @Override
    public String automaticUpdateDb(Set<Class> classSet) {
        StringBuffer sql = new StringBuffer();
        //扫描实体类包的实体class
        Map<String, Class> map = new HashMap<>(classSet.size());
        classSet.forEach(clazz->{
            map.put(SqlUtil.beanNameToTableName(clazz), clazz);
        });
        List<Table> tableList = JdbcUtils.getAllTable();
        //初始化的时候,tableList可能为null
        if(tableList!=null&&tableList.size()>0) {
            Iterator<Table> tableIterator = tableList.iterator();
            while (tableIterator.hasNext()) {
                Table table = (Table) tableIterator.next();
                if (map.containsKey(table.getTableName())) {
                    Class clazz = map.get(table.getTableName());
                    Map<String, Object> clazzMap = new HashMap<>();
                    List<Field> fieldsList = BeanUtil.getAllField(clazz);
                    Iterator<Field> fieldsIterator = fieldsList.iterator();
                    while (fieldsIterator.hasNext()) {
                        Field f = fieldsIterator.next();
                        clazzMap.put(SqlUtil.caseToHump(f.getName()), f);
                    }
                    List<Column> columnList = table.getColumns();

                    Iterator<Column> columnIterator = columnList.iterator();
                    while (columnIterator.hasNext()) {
                        Column column = columnIterator.next();
                        if (clazzMap.containsKey(column.getColumnName())) {
                            clazzMap.remove(column.getColumnName());
                            columnIterator.remove();
                        }

                    }
                    columnIterator = columnList.iterator();
                    while (columnIterator.hasNext()) {
                        Column column = columnIterator.next();
                        sql.append("ALTER TABLE " + table.getTableName() + " DROP COLUMN " + column.getColumnName() + ";");
                    }

                    for (String key : clazzMap.keySet()) {
                        Field f = (Field) clazzMap.get(key);
                        String column = SqlUtil.caseToHump(f.getName());
                        String columnType = dataTypeMap.get(f.getGenericType().toString());
                        String lengthStr = "";
                        if ("varchar".equals(columnType) || "int".equals(columnType)) {
                            Length length = f.getAnnotation(Length.class);
                            if (length != null) {
                                lengthStr = "(" + length.value() + ")";
                            } else {
                                lengthStr = "(50)";
                            }
                        }
                        sql.append("ALTER TABLE " + table.getTableName() + " ADD COLUMN " + column + " " + columnType + lengthStr + ";");
                    }
                    map.remove(table.getTableName());
                }
            }
        }

        for (Map.Entry<String,Class> entry:map.entrySet()){
            sql.append(this.createTableStr(entry.getValue()));
        }
        return sql.toString();
    }

    @Override
    public String automaticUpdateDbNew(QueueDto<Class> classQueueDto) {
        StringBuffer sql = new StringBuffer();
        List<Table> tableList = JdbcUtils.getAllTable();
        Map<String,Table> tableMap = new HashMap<>(tableList.size());
        tableList.forEach((table)->{
            tableMap.put(table.getTableName(),table);
        });

        ExecutorService executorService = Executors.newFixedThreadPool(6);
        while (classQueueDto.hasNext()){
            executorService.execute(()->{
                Class clazz = classQueueDto.pop();
                String tableName = SqlUtil.beanNameToTableName(clazz);
                //判断表是否存在
                if (tableMap.containsKey(tableName)){
                    List<Field> fieldsList = BeanUtil.getAllField(clazz);
                    Map<String,Field> clazzMap = new HashMap<>(fieldsList.size());
                    fieldsList.forEach((field)->{
                        clazzMap.put(SqlUtil.caseToHump(field.getName()),field);
                    });
                    List<Column> columnList = tableMap.get(tableName).getColumns();
                    Iterator<Column> columnIterator = columnList.iterator();
                    while (columnIterator.hasNext()) {
                        Column column = columnIterator.next();
                        if (clazzMap.containsKey(column.getColumnName())) {
                            clazzMap.remove(column.getColumnName());
                            columnIterator.remove();
                        }
                    }
                    columnIterator = columnList.iterator();
                    while (columnIterator.hasNext()) {
                        Column column = columnIterator.next();
                        sql.append("ALTER TABLE " + tableName + " DROP COLUMN " + column.getColumnName() + ";");
                    }
                    for (Map.Entry<String,Field> entry:clazzMap.entrySet()){
                        Field f = entry.getValue();
                        String column = SqlUtil.caseToHump(f.getName());
                        String columnType = dataTypeMap.get(f.getGenericType().toString());
                        String lengthStr = "";
                        if ("varchar".equals(columnType) || "int".equals(columnType)) {
                            Length length = f.getAnnotation(Length.class);
                            if (length != null) {
                                lengthStr = "(" + length.value() + ")";
                            } else {
                                lengthStr = "(50)";
                            }
                        }
                        sql.append("ALTER TABLE " + tableName + " ADD COLUMN " + column + " " + columnType + lengthStr + ";");
                    }
                }else {
                    sql.append(this.createTableStr(clazz));
                }
            });
        }
        executorService.shutdown();
        return sql.toString();
    }

    @Override
    public String concatPageSql(String sql, PageInterface pageInterface) {

        StringBuffer sb=new StringBuffer(sql);
        Integer index=(pageInterface.getPage()-1)*pageInterface.getPageSize();
        sb.append(" limit ").append(index).append(","+pageInterface.getPageSize());
        return sb.toString();
    }

    @Override
    public String createTableStr(Class clazz) {
        StringBuffer sql=new StringBuffer("CREATE TABLE ");
        //表名
        String tableName = SqlUtil.beanNameToTableName(clazz);
        sql.append(tableName);
        sql.append("(");
        sql.append("id bigint auto_increment not null,");
        List<Map<String,String>> mapList= BeanUtil.getFileInfo(BeanUtil.getField(clazz));
        for (Map<String,String> map:mapList){
            String dataTypeStr = dataTypeMap.get(map.get("fieldType"));
            sql.append(SqlUtil.caseToHump(map.get("fieldName"))+" "+dataTypeStr);
            if ("varchar".equals(dataTypeStr)||"int".equals(dataTypeStr)){

                if (map.containsKey("fieldLength")) {
                    sql.append("("+map.get("fieldLength")+")");
                }
                else {
                    sql.append("(50)");
                }
            }
            sql.append(",");
        }
        sql.append("primary key(id)");
        sql.append(")ENGINE=InnoDB DEFAULT CHARSET=utf8;");

        return sql.toString();
    }


}
