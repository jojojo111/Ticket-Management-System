package com.software.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.software.model.Admin;
import com.software.util.DBHelp;

/**
 * 管理员登陆
 * 
 * @author 韩冬
 *
 */
public class AdminDao {

	/**
	 * 登陆
	 */
	public boolean adminLogin(Admin admin) {
		boolean flag = false;

		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();
			st = connection.createStatement();
			String sql = "select admin_id from tbl_admin where admin_loginname = '" + admin.getAdmin_loginname()
					+ "' and admin_loginpwd = '" + admin.getAdmin_loginpwd() + "'";

			rs = st.executeQuery(sql);
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}

		return flag;
	}

	public Admin adminLogin(String admin_loginname, int admin_loginpwd) {
		Admin admin = new Admin();
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();
			st = connection.createStatement();
			String sql = "select admin_id,admin_loginname,admin_loginpwd from tbl_admin where admin_loginname='"
					+ admin_loginname + "' and admin_loginpwd=" + admin_loginpwd;
			rs = st.executeQuery(sql);
			if (rs.next()) {
				admin.setAdmin_id(rs.getInt("admin_id"));
				admin.setAdmin_loginname(rs.getString("admin_loginname"));
				admin.setAdmin_loginpwd(rs.getInt("admin_loginpwd"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return admin;
	}
}
