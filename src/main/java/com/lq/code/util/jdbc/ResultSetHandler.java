package com.lq.code.util.jdbc;

import java.sql.ResultSet;

/**
 * 结果集处理
 * @author qi
 */
public interface ResultSetHandler {

	 Object handler(ResultSet rs);

}
