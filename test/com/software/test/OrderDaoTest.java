package com.software.test;

import java.util.List;

import org.junit.Test;

import com.software.dao.OrderDao;

public class OrderDaoTest {

	/**
	 * 测试按条件多表连接查询使用List集合方法
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMethod5() throws Exception {
		OrderDao order_dao_my = new OrderDao();
		List<List> order = order_dao_my.findorderByCondition(null, "430521199710191000", null, 1, 2);
		int i = 0;
		for (; i < order.size(); i++) {
			List data = order.get(i);
			System.out.println(data.toString());
		}
		if (i == 0) {
			System.out.println("未查询到任何结果！");
		}
	}

	/**
	 * 测试统计订单，未完成
	 */
	@Test
	public void testMethod6() {
		String test_str = "2019";
		OrderDao orderdao = new OrderDao();
		// System.out.println(orderdao.countOrder(test_str));
	}

}