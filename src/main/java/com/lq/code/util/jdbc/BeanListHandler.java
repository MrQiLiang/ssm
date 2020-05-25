package com.lq.code.util.jdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 批量结果集转实体类
 * @author qi
 */
public class BeanListHandler implements ResultSetHandler {

	private Class<?> clazz;

	private ResultSetHandler resultSetHandler;

	public BeanListHandler(Class<?> clazz) {
		this.clazz = clazz;
		this.resultSetHandler = new BeanHander(clazz);
	}

	@Override
	public Object handler(ResultSet rs) {

		try {
			List<Object> list = new ArrayList<>();
			while (rs.next()) {
				Object bean = resultSetHandler.handler(rs);
				list.add(bean);
			}
			return list.size() > 0 ? list : null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
