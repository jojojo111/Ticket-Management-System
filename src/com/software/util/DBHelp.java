package com.software.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * 连接数据库操作的工具类
 * 
 * @author Administrator
 *
 */
public class DBHelp {

	/*
	 * private static String DBDRIVER = null; private static String DBCONN =
	 * null; private static String USER = null; private static String PWD =
	 * null;
	 */
	private static DataSource dataSource;
	static {
		// 加载.properties文件
		// InputStream is=
		// DBHelp.class.getClassLoader().getResourceAsStream("jdbc.properties");
		// 使用Properties处理流
		// 使用load() 方法加载指定的流
		// 使用getProperty(key),获取需要的值
		/*
		 * Properties props=new Properties(); try { props.load(is); DBDRIVER =
		 * props.getProperty("jdbc.className");
		 * DBCONN=props.getProperty("jdbc.url");
		 * USER=props.getProperty("jdbc.user");
		 * PWD=props.getProperty("jdbc.password"); } catch (IOException e) { //
		 * TODO 自动生成的 catch 块 e.printStackTrace(); }
		 */

		InputStream in = DBHelp.class.getClassLoader().getResourceAsStream("dbcp.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			dataSource = BasicDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	public static Connection getConnect() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return connection;
	}

	/*
	 * // 数据库驱动 private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	 * // 数据库连接字符串 private static final String DBCONN =
	 * "jdbc:mysql://localhost:3306/ticket"; // 用户名 private static final String
	 * USER = "root"; // 密码 private static final String PWD = "root";
	 */
	/**
	 * get the connection
	 * 
	 * @return
	 */
	/*
	 * public static Connection getConnect() { Connection connection = null; try
	 * { Class.forName(DBDRIVER); connection =
	 * DriverManager.getConnection(DBCONN, USER, PWD); } catch
	 * (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch(Exception e) { e.printStackTrace(); }
	 * 
	 * return connection; }
	 */

	/**
	 * 执行单表的增删改操作
	 * 
	 * @param sql
	 *            :执行的sql语句 eg: insert into tbl_user(loginname,pwd) values
	 *            ('scott','123'); update tbl_user set loginname='sys' where
	 *            id=2; delete from tbl_user where id=2;
	 * @return 执行sql语句返回的影响行数
	 */

	public static int executeSql(String sql) {
		int count = 0;
		Connection connection = getConnect();
		Statement st = null;
		try {
			connection.setAutoCommit(false);
			st = connection.createStatement();
			count = st.executeUpdate(sql);
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			// 关闭相关的数据库对象
			closeAll(null, st, connection);
		}
		return count;
	}

	/**
	 * 关闭数据库对象
	 */
	public static void closeAll(ResultSet rs, Statement st, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}