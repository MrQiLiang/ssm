package com.lq.code.util.sql;

import com.lq.cms.vo.BasePageVo;
import com.lq.code.annotation.Length;
import com.lq.code.util.BeanUtil;
import com.lq.code.util.jdbc.JdbcUtils;
import com.lq.code.util.jdbc.mode.Column;
import com.lq.code.util.jdbc.mode.Table;
import org.apache.commons.collections.map.HashedMap;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by qi_liang on 2018/6/2.
 */
public class MysqlBuilder extends AbstractDbBuiler {

    private static Map<String,String> dataTypeMap=new HashedMap();

    static {

        dataTypeMap.put("class java.lang.String","varchar");
        dataTypeMap.put("class java.util.Date","date");
        dataTypeMap.put("class java.lang.Integer","int");
        dataTypeMap.put("class java.lang.Long","int");
    }


    @Override
    public String automaticUpdateDb(Set<Class> classSet) {
        StringBuffer sql = new StringBuffer();
        //扫描实体类包的实体class
        Set<Class> set = classSet;
        Map<String, Class> map = new HashMap<>();
        Iterator<Class> setIterator = set.iterator();
        while (setIterator.hasNext()){
            Class clazz = setIterator.next();
            map.put(SqlUtil.beanNameToTableName(clazz), clazz);
         }

        List<Table> tableList = JdbcUtils.getAllTable();
         Iterator<Table> tableIterator = tableList.iterator();
        while (tableIterator.hasNext()){
            Table table = (Table) tableIterator.next();
                if (map.containsKey(table.getTableName())) {
                    Class clazz = map.get(table.getTableName());
                    Map<String, Object> clazzMap = new HashMap<>();
                    List<Field> fieldsList = BeanUtil.getAllField(clazz);
                    Iterator<Field> fieldsIterator = fieldsList.iterator();
                    while (fieldsIterator.hasNext()){
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
                    while (columnIterator.hasNext()){
                        Column column = columnIterator.next();
                        sql.append("ALTER TABLE " + table.getTableName() + " DROP COLUMN " + column.getColumnName() + ";");
                    }

                    for (String key : clazzMap.keySet()) {
                        Field f = (Field) clazzMap.get(key);
                        String column = SqlUtil.caseToHump(f.getName());
                        String columnType = dataTypeMap.get(f.getGenericType().toString());
                        String lengthStr = "";
                        if (columnType.equals("varchar") || columnType.equals("int")) {
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

        for (String key : map.keySet()) {
            sql.append(this.createTableStr(map.get(key)));
        }

        return sql.toString();
    }

    @Override
    public String concatPageSql(String sql, BasePageVo vo) {

        StringBuffer sb=new StringBuffer(sql);
        Integer index=(vo.getPage()-1)*vo.getRows();
        sb.append(" limit ").append(index).append(","+vo.getRows());
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
            if (dataTypeStr.equals("varchar")||dataTypeStr.equals("int")){

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
        sql.append(")ENGINE=MyISAM DEFAULT CHARSET=utf8;");

        return sql.toString();
    }


}
