package com.lq.code.util.jdbc;

import com.lq.code.util.sql.SqlUtil;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class BeanHander implements ResultSetHandler {

	private Class<?> clazz;

	public BeanHander(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	public Object handler(ResultSet rs) {
		try {

			Object bean = clazz.newInstance();
			ResultSetMetaData metadata = rs.getMetaData();
			int coulumnCount = metadata.getColumnCount();

		 Field [] fields = clazz.getDeclaredFields();
		 for (Field f:fields){
		 	String fieldName = f.getName();
		 	String columnName = SqlUtil.caseToHump(fieldName);
		 	try {
				Object columnData = rs.getObject(columnName);
				f.setAccessible(true);
				f.set(bean, columnData);
			}catch (SQLException e){
		 		continue;
			}

		 }
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
