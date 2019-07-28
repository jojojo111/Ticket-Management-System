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
 * �������ݿ�����Ĺ�����
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
		// ����.properties�ļ�
		// InputStream is=
		// DBHelp.class.getClassLoader().getResourceAsStream("jdbc.properties");
		// ʹ��Properties������
		// ʹ��load() ��������ָ������
		// ʹ��getProperty(key),��ȡ��Ҫ��ֵ
		/*
		 * Properties props=new Properties(); try { props.load(is); DBDRIVER =
		 * props.getProperty("jdbc.className");
		 * DBCONN=props.getProperty("jdbc.url");
		 * USER=props.getProperty("jdbc.user");
		 * PWD=props.getProperty("jdbc.password"); } catch (IOException e) { //
		 * TODO �Զ����ɵ� catch �� e.printStackTrace(); }
		 */

		InputStream in = DBHelp.class.getClassLoader().getResourceAsStream("dbcp.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		try {
			dataSource = BasicDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}

	public static Connection getConnect() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return connection;
	}

	/*
	 * // ���ݿ����� private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	 * // ���ݿ������ַ��� private static final String DBCONN =
	 * "jdbc:mysql://localhost:3306/ticket"; // �û��� private static final String
	 * USER = "root"; // ���� private static final String PWD = "root";
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
	 * ִ�е������ɾ�Ĳ���
	 * 
	 * @param sql
	 *            :ִ�е�sql��� eg: insert into tbl_user(loginname,pwd) values
	 *            ('scott','123'); update tbl_user set loginname='sys' where
	 *            id=2; delete from tbl_user where id=2;
	 * @return ִ��sql��䷵�ص�Ӱ������
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
			// �ر���ص����ݿ����
			closeAll(null, st, connection);
		}
		return count;
	}

	/**
	 * �ر����ݿ����
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