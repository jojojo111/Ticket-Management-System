package com.software.test;

import java.util.List;

import org.junit.Test;

import com.software.dao.UserDao;
import com.software.model.User;

public class UserDaoTest {

	/*
	 * 查询所有用户测试 作者：王恒
	 */
	@Test
	public void testfindAllUser() {
		UserDao userdao = new UserDao();
		List<User> users = userdao.findAllUser(1, 2);
		for (int i = 0; i < users.size(); i++) {
			User data = users.get(i);
			System.out.println(data.toString());
		}
	}

	/*
	 * 按身份证号查询 作者：王恒
	 */
	@Test
	public void testCriteriaQuery() {
		String ID = "145295369874256000";
		UserDao userdao = new UserDao();
		List<User> users = userdao.CriteriaQuery(ID);
		for (int i = 0; i < users.size(); i++) {
			User data = users.get(i);
			System.out.println(data.toString());
		}
	}

	/*
	 * 重置密码测试 作者：郗瑞
	 */
	@Test
	public void testresetPassword() {
		int user_id = 2;
		UserDao userdao = new UserDao();
		boolean flag = userdao.resetPassword(user_id);
		if (flag)
			System.out.println("success");
		else
			System.out.println("false");
	}
}