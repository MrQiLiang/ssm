package com.lq.code.dao.impl;

import com.lq.code.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by qi on 2017/11/22.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

    @Autowired(required = false)
    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private Class<T> entityClass;

    public BaseDaoImpl() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];
    }

    public  void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public  void setNamedParameterJdbcTemplate(){
        namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
    }


    @Override
    public Long save(T entity) {
        if (namedParameterJdbcTemplate==null){
            setNamedParameterJdbcTemplate();
        }

        SqlParameterSource parameterSource=new BeanPropertySqlParameterSource(entity);


        return null;
    }

    @Override
    public void update(T t) {
        StringBuffer sql=new StringBuffer();
        Field[] fields1= entityClass.getFields();
        for (Field field:fields1){
            field.setAccessible(true);
            System.out.println(field);
        }
        Field[] fields=entityClass.getDeclaredFields();
        for (Field field:fields){
            System.out.println(field);
        }
    }

    @Override
    public T findOne(Long id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void batchSave(List<T> entitylist) {

    }

    @Override
    public void batchUpdate(List<T> entitylist) {

    }

    @Override
    public void batchDelete(List<T> entitylist) {

    }

    private String makeSql(String sqlType){
        StringBuffer sql=new StringBuffer();
        Field[] fields=entityClass.getFields();
        for (Field field:fields){
            System.out.println(field);
        }
        return  sql.toString();
    }

    //将类名转换为表面，开启驼峰命名
    public String openHump(String entityName){
        StringBuffer strBuffer=new StringBuffer();
        char[] charArray=entityName.toCharArray();
        for (int i=0;i<charArray.length;i++){
            if (i==0){
                strBuffer.append(charArray[i]);
                continue;
            }
            if (Character.isUpperCase(charArray[i])){
                strBuffer.append("_"+charArray[i]);
            }else {
                strBuffer.append(charArray[i]);
            }
        }
        return strBuffer.toString().toUpperCase();
    }


}
