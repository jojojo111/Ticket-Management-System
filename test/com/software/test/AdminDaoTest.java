package com.software.test;

import org.junit.Test;

import com.software.dao.AdminDao;
import com.software.model.Admin;

public class AdminDaoTest {

	/**
	 * ²âÊÔµÇÂ½
	 */
	@Test
	public void testAdminLogin() {
		Admin admin = new Admin();
		admin.setAdmin_loginname("admin");
		admin.setAdmin_loginpwd(123456);

		AdminDao admindao = new AdminDao();
		boolean flag = admindao.adminLogin(admin);
		if (flag) {
			System.out.println("success");
		} else {
			System.out.println("failer");
		}
	}
}
