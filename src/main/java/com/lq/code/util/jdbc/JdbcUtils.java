package com.lq.code.util.jdbc;

import com.lq.code.util.PropsUtil;
import com.lq.code.util.StringUtil;
import com.lq.code.util.jdbc.mode.Column;
import com.lq.code.util.jdbc.mode.DbInfo;
import com.lq.code.util.jdbc.mode.Table;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class JdbcUtils {


	private static String driver = null;

	private static String url = null;

	private static String username = null;

	private static String password = null;

	static {
		try {
			Properties prop = PropsUtil.loadProps("jdbc.properties");

			driver = PropsUtil.getString(prop,"jdbc.driver");

			url =  PropsUtil.getString(prop,"jdbc.url");

			username = PropsUtil.getString(prop,"jdbc.user");

			password = PropsUtil.getString(prop,"jdbc.password");

			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	public static DbInfo getDBInfo()  {
		Connection conn = null;
		DatabaseMetaData metaData;
		DbInfo dbInfo = new DbInfo();
		try {
			conn = getConnection();
			metaData = conn.getMetaData();
			dbInfo.setName(metaData.getDatabaseProductName());
			dbInfo.setVersion(metaData.getDatabaseProductVersion());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn,null,null);
		}

		return dbInfo;
	}

	/**
	 *  返回所有表名
	 */
	public static List<Table> getAllTable(){

		List<Table> tableNameList = null;
		Connection conn = null;
		DatabaseMetaData metaData = null;
		ResultSet  rs =null;
		ResultSetMetaData resultSetMetaData = null;
		try{
			conn = getConnection();
			//获取数据库名称
			String dbName = conn.getCatalog();
			metaData = conn.getMetaData();
			rs = metaData.getTables(dbName,null,null,new String[]{"TABLE"});
			ResultSetHandler rsh = new BeanListHandler(Table.class);
			tableNameList =(List<Table>)rsh.handler(rs);
			if (tableNameList!=null&&tableNameList.size()>0) {
				for (Table table : tableNameList) {
					ResultSet resultSet = metaData.getColumns(null, null, table.getTableName(), null);
					ResultSetMetaData crsmd = resultSet.getMetaData();
					ResultSetHandler columnSetHandler = new BeanListHandler(Column.class);
					List<Column> columnList = (List<Column>) columnSetHandler.handler(resultSet);
					table.setColumns(columnList);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn,null,rs);
		}
		return tableNameList;
	}



	public static void update(String sql, Object params[]) {
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			st = conn.prepareStatement(sql);
			if(params!=null) {
				for (int i = 0; i < params.length; i++) {
					st.setObject(i + 1, params[i]);
				}
			}

			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			release(conn, st, rs);
		}
	}

	public static void beatchUpdate(String sql){}

	public static void createTable(String sql){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			st = conn.createStatement();
			if(StringUtil.isNotNull(sql)) {
				String[] sqlArray = sql.split(";");
				for (String str : sqlArray) {
					st.executeUpdate(str);
				}
			}

//			st.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			release(conn, st, rs);
		}

	}

	public static Object query(String sql, Object params[], ResultSetHandler rsh) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			st = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				st.setObject(i + 1, params[i]);
			}
			rs = st.executeQuery();
			return rsh.handler(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			release(conn, st, rs);
		}
		return rs;
	}

	public static void release(Connection conn, Statement st, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}



}
