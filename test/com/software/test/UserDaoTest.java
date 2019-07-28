package com.software.test;

import java.util.List;

import org.junit.Test;

import com.software.dao.UserDao;
import com.software.model.User;

public class UserDaoTest {

	/*
	 * ��ѯ�����û����� ���ߣ�����
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
	 * �����֤�Ų�ѯ ���ߣ�����
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
	 * ����������� ���ߣ�ۭ��
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