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
		/**	for (int i = 0; i < coulumnCount; i++) {
				String coulmnName = metadata.getColumnLabel(i + 1);
				Object coulmnData = rs.getObject(i + 1);
				String fieldName = SqlUtil.humpToCase(coulmnName);
				Field f = null;
				try {
					f = clazz.getDeclaredField(fieldName);
				}catch (NoSuchFieldException e){
					continue;
				}
				f.setAccessible(true);
				f.set(bean, coulmnData);
			}
		 **/
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
