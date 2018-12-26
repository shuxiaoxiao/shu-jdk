package com.shuframework.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shuframework.jdkutil.MyBeanUtil;

/**
 * 数据库连接工具
 * 
 * @author shu
 *
 */
public class JdbcUtil {

	/**默认驱动*/
	private static final String DRIVER_DEFAULT = "com.mysql.jdbc.Driver";
	
	private JdbcUtil() {
	}
	
	/**
	 * 获得数据库的连接对象(Connection), 默认数据源是mysql
	 * @param url
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConn(String url, String username, String password) throws SQLException {
		return getConn(DRIVER_DEFAULT, url, username, password);
	}
	
	/**
	 * 获得数据库的连接对象(Connection)
	 * @param driver
	 * @param url
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConn(String driver, String url, String username, String password) throws SQLException {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Connection connection = null;
		connection = DriverManager.getConnection(url, username, password);
		System.out.println("数据库连接成功");
		return connection;
	}

	/**
	 * 释放连接，如果参数没有就设置为null
	 * @param connection
	 * @param pstmt
	 * @param resultSet
	 * @throws SQLException 
	 */
	public static void releaseConn(Connection connection, PreparedStatement pstmt, ResultSet resultSet)
			throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
	
	/**
	 * 执行新增、修改、删除操作
	 * 
	 * @param connection
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static int update(Connection connection, String sql, Object... params) throws SQLException {
		PreparedStatement pstmt = initStatement(connection, sql, params);
		return pstmt.executeUpdate();
	}

	/**
	 * 执行新增、修改、删除操作
	 * 
	 * @param connection
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static int update(Connection connection, String sql, List<?> params) throws SQLException {
		PreparedStatement pstmt = initStatement(connection, sql, params);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 执行查询操作
	 * 
	 * @param connection
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static Map<String, Object> query2Map(Connection connection, String sql, List<?> params) throws SQLException {
		Map<String, Object> map = new HashMap<>();
		PreparedStatement pstmt = initStatement(connection, sql, params);
		ResultSet resultSet = pstmt.executeQuery();// 返回查询结果
		
		// 获取此 ResultSet 对象的列的编号、类型和属性。
		ResultSetMetaData metaData = resultSet.getMetaData();
		int col_len = metaData.getColumnCount();// 获取列的长度
		while (resultSet.next()) {
			for (int i = 0; i < col_len; i++) {
				String cols_name = metaData.getColumnName(i + 1);
				Object cols_value = resultSet.getObject(cols_name);
//				// 列的值没有时，设置列值为""
//				if (cols_value == null){
//					cols_value = "";
//				}
				map.put(cols_name, cols_value);
			}
		}
		return map;
	}
	
	/**
	 * 执行查询操作
	 * 
	 * @param connection
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static List<Map<String, Object>> query2ListMap(Connection connection, String sql, List<?> params) throws SQLException {
		List<Map<String, Object>> mapList = new ArrayList<>();
		PreparedStatement pstmt = initStatement(connection, sql, params);
		ResultSet resultSet = pstmt.executeQuery();// 返回查询结果
		
		// 获取此 ResultSet 对象的列的编号、类型和属性。
		ResultSetMetaData metaData = resultSet.getMetaData();
		int col_len = metaData.getColumnCount();// 获取列的长度
		Map<String, Object> map = null;
		while (resultSet.next()) {
			map = new HashMap<>();
			for (int i = 0; i < col_len; i++) {
				String cols_name = metaData.getColumnName(i + 1);
				Object cols_value = resultSet.getObject(cols_name);
//				// 列的值没有时，设置列值为""
//				if (cols_value == null){
//					cols_value = "";
//				}
				map.put(cols_name, cols_value);
			}
			mapList.add(map);
		}
		return mapList;
	}
	
	/**
	 * 执行查询操作
	 * 
	 * @param connection
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static <T> T query2Bean(Connection connection, String sql, Class<T> clazz, List<?> params) throws Exception {
		T bean = clazz.newInstance();
		PreparedStatement pstmt = initStatement(connection, sql, params);
		ResultSet resultSet = pstmt.executeQuery();// 返回查询结果
		
		// 获取此 ResultSet 对象的列的编号、类型和属性。
		ResultSetMetaData metaData = resultSet.getMetaData();
		int col_len = metaData.getColumnCount();// 获取列的长度
		while (resultSet.next()) {
			for (int i = 0; i < col_len; i++) {
				String cols_name = metaData.getColumnName(i + 1);
				Object cols_value = resultSet.getObject(cols_name);
//				// 列的值没有时，设置列值为""
//				if (cols_value == null){
//					cols_value = "";
//				}
				MyBeanUtil.setProperty(bean, cols_name, cols_value);
			}
		}
		return bean;
	}
	
	/**
	 * 执行查询操作
	 * 
	 * @param connection
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static <T> List<T> query2ListBean(Connection connection, String sql, Class<T> clazz, List<?> params) throws Exception {
		List<T> mapList = new ArrayList<>();
		PreparedStatement pstmt = initStatement(connection, sql, params);
		ResultSet resultSet = pstmt.executeQuery();// 返回查询结果
		
		// 获取此 ResultSet 对象的列的编号、类型和属性。
		ResultSetMetaData metaData = resultSet.getMetaData();
		int col_len = metaData.getColumnCount();// 获取列的长度
		T bean = null;
		while (resultSet.next()) {
			bean = clazz.newInstance();
			for (int i = 0; i < col_len; i++) {
				String cols_name = metaData.getColumnName(i + 1);
				Object cols_value = resultSet.getObject(cols_name);
//				// 列的值没有时，设置列值为""
//				if (cols_value == null){
//					cols_value = "";
//				}
				MyBeanUtil.setProperty(bean, cols_name, cols_value);
			}
			mapList.add(bean);
		}
		return mapList;
	}

	
//	protected static void result2Obj(ResultSet resultSet, Object obj) throws SQLException {
//		Map<String, Object> map = null;
////		T bean = null;
//		if(obj instanceof Map){
//			map = (Map<String, Object>)obj;
//		}
//		// 获取此 ResultSet 对象的列的编号、类型和属性。
//		ResultSetMetaData metaData = resultSet.getMetaData();
//		int col_len = metaData.getColumnCount();// 获取列的长度
//		while (resultSet.next()) {
//			for (int i = 0; i < col_len; i++) {
//				String cols_name = metaData.getColumnName(i + 1);
//				Object cols_value = resultSet.getObject(cols_name);
////				// 列的值没有时，设置列值为""
////				if (cols_value == null){
////					cols_value = "";
////				}
//				map.put(cols_name, cols_value);
//			}
//		}
//	}

	/**
	 * 创建PreparedStatement 并给参数赋值
	 * 
	 * @param connection
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	protected static PreparedStatement initStatement(Connection connection, String sql, Object... params)
			throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(sql);
		int index = 1;
		// 填充sql语句中的占位符
		if (params != null) {
			int size = params.length;
			for (int i = 0; i < size; i++) {
				pstmt.setObject(index++, params[i]);
			}
		}
		return pstmt;
	}
	
	/**
	 * 创建PreparedStatement 并给参数赋值
	 * 
	 * @param connection
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	protected static PreparedStatement initStatement(Connection connection, String sql, List<?> params)
			throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(sql);
		int index = 1;
		// 填充sql语句中的占位符
		if (params != null) {
			int size = params.size();
			for (int i = 0; i < size; i++) {
				pstmt.setObject(index++, params.get(i));
			}
		}
		return pstmt;
	}

}