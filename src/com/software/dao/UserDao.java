package com.software.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.software.model.User;
import com.software.util.DBHelp;

/**
 * User�����ݿ������
 * 
 * @author ���㡢ۭ��
 *
 */
public class UserDao {
	/**
	 * ��ѯ�û���Ϣ ���ߣ�����
	 * 
	 * @return
	 */
	public List<User> findAllUser(int currentPage, int pageSize) {
		List<User> users = new ArrayList<User>();
		Connection connection = DBHelp.getConnect();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = connection.createStatement();
			String sql = "select user_id,user_loginname,user_loginpwd,user_realname,user_cardnumber,user_telephone,user_gender,user_brithday,remark1 from tbl_user";
			sql = sql + " limit " + (currentPage - 1) * pageSize + "," + pageSize;
			rs = st.executeQuery(sql);
			User data = null;
			while (rs.next()) {
				data = new User();
				data.setUser_id(rs.getInt("user_id"));
				data.setUser_loginname(rs.getString("user_loginname"));
				data.setUser_loginpwd(rs.getString("user_loginpwd"));
				data.setUser_realname(rs.getString("user_realname"));
				data.setUser_cardnumber(rs.getString("user_cardnumber"));
				data.setUser_telephone(rs.getString("user_telephone"));
				data.setUser_gender(rs.getString("user_gender"));
				data.setUser_birthday(rs.getString("user_brithday"));
				data.setRemark1(rs.getString("remark1"));

				users.add(data);

			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return users;
	}

	/**
	 * ��������ѯ ���ߣ����� ���������֤��
	 */
	public List<User> CriteriaQuery(String user_cardnumber) {
		List<User> users = new ArrayList<User>();

		Connection connection = DBHelp.getConnect();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = connection.createStatement();
			String sql = "select user_id, user_loginname, user_loginpwd, user_realname, user_cardnumber, user_telephone, user_gender, user_brithday,remark1 \r\n"
					+ "from tbl_user\r\n" + " where user_cardnumber = '" + user_cardnumber + "'";
			rs = st.executeQuery(sql);
			User data = null;
			while (rs.next()) {
				data = new User();
				data.setUser_id(rs.getInt("user_id"));
				data.setUser_loginname(rs.getString("user_loginname"));
				data.setUser_loginpwd(rs.getString("user_loginpwd"));
				data.setUser_realname(rs.getString("user_realname"));
				data.setUser_cardnumber(rs.getString("user_cardnumber"));
				data.setUser_telephone(rs.getString("user_telephone"));
				data.setUser_gender(rs.getString("user_gender"));
				data.setUser_birthday(rs.getString("user_brithday"));
				data.setRemark1(rs.getString("remark1"));

				users.add(data);

			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}

		return users;

	}

	/**
	 * �������� ���ߣ�ۭ��
	 */
	public boolean resetPassword(int user_id) {
		boolean flag = false;
		String sql = "UPDATE tbl_user\r\n" + "SET user_loginpwd = \"000000\"\r\n" + "where user_id = " + user_id + "";
		int count = DBHelp.executeSql(sql);
		if (count > 0)
			flag = true;

		return flag;

	}

	/**
	 * �����˻� ���ߣ�����
	 */
	public boolean freezeUser(int user_id) {
		boolean flag = false;
		String sql = "update tbl_user set remark1='1' where user_id=" + user_id;
		// System.out.println(sql);
		int count = DBHelp.executeSql(sql);
		if (count > 0)
			flag = true;

		return flag;
	}

	/**
	 * ��������˻� ���ߣ�����
	 */
	public boolean unfreezeUser(int user_id) {
		boolean flag = false;
		String sql = "update tbl_user set remark1='0' where user_id=" + user_id;
		// System.out.println(sql);
		int count = DBHelp.executeSql(sql);
		if (count > 0)
			flag = true;

		return flag;
	}

	/**
	 * ��ȡ������� ���ߣ�����
	 */
	public int getCountUsers() {
		int count = 0;
		Connection connection = DBHelp.getConnect();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = connection.createStatement();
			String sql = "select count(*) from tbl_user";
			rs = st.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return count;
	}

	/**
	 * ��������ȡ������� ���ߣ�����
	 */
	public int getCountUsers(String user_cardnumber) {
		int count = 0;
		Connection connection = DBHelp.getConnect();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = connection.createStatement();
			String sql = "select count(*) from tbl_user where user_cardnumber = '" + user_cardnumber + "'";
			rs = st.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return count;
	}

}
