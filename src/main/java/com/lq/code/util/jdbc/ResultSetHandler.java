package com.lq.code.util.jdbc;

import java.sql.ResultSet;

/**
 * 结果集处理
 * @author qi
 */
public interface ResultSetHandler {

	/**
	 *  结果集封装成对象
	 * @param rs
	 * @return
	 */
	 Object handler(ResultSet rs);

}
