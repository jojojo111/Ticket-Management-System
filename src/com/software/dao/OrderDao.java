package com.software.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.software.model.Order;
import com.software.util.DBHelp;

/**
 * 订单
 * 
 * @author 郭鹏哲
 *
 */
public class OrderDao {
	/**
	 * 按条件查询订单并分页 条件：订单编号、用户身份证号、创建时间
	 */
	public List<List> findorderByCondition(String order_number, String user_cardnumber, String order_creation_time,
			int currentPage, int pageSize) throws Exception {
		List<List> buffer = new ArrayList<List>();

		// 连接数据库实现查询操作
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			connection = DBHelp.getConnect();
			st = connection.createStatement();
			String sql = "select order_number,user_realname,user_cardnumber,train_number,"
					+ "order_creation_time,order_tiket_price,order_pay_type,user_telephone,order_seat_type "
					+ "from tbl_order o,tbl_user u,tbl_train t "
					+ "where o.user_id = u.user_id and o.train_id = t.train_id";
			if (order_number != null && order_number.trim().length() > 0) {
				sql = sql + " and order_number='" + order_number + "'";
			}
			if (user_cardnumber != null && user_cardnumber.trim().length() > 0) {
				sql = sql + " and user_cardnumber='" + user_cardnumber + "'";
			}
			if (order_creation_time != null && order_creation_time.trim().length() > 0) {
				sql = sql + " and order_creation_time like '" + order_creation_time + '%' + "'";
			}

			sql = sql + " limit " + (currentPage - 1) * pageSize + "," + pageSize;

			rs = st.executeQuery(sql);
			List data = null;

			while (rs.next()) {
				data = new ArrayList();
				data.add(rs.getString("order_number"));
				data.add(rs.getString("user_realname"));
				data.add(rs.getString("user_cardnumber"));
				data.add(rs.getString("train_number"));
				data.add(rs.getString("order_creation_time"));
				data.add(rs.getDouble("order_tiket_price"));
				data.add(rs.getString("order_pay_type"));
				data.add(rs.getString("user_telephone"));
				data.add(rs.getString("order_seat_type"));

				buffer.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return buffer;
	}

	/**
	 * 按照车次信息和用户姓名进行多表连接统计订单数量 参数：车次号，用户真实姓名，订单创建时间 返回：符合条件的订单数量
	 * 
	 * @return
	 */
	public int countOrderByCondition(Order order, String order_number, String user_cardnumber,
			String order_creation_time) {
		int count = 0;
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			connection = DBHelp.getConnect();
			st = connection.createStatement();
			String sql = "select count(*) as result from tbl_order ";
			if (order_number != null && order_number.trim().length() > 0) {
				sql = sql + "o,tbl_train t where o.train_id = t.train_id and order_number = '" + order_number + "'";
			}
			if (user_cardnumber != null && user_cardnumber.trim().length() > 0) {
				sql = sql + "o,tbl_user u where o.user_id = u.user_id and user_cardnumber = '" + user_cardnumber + "'";
			}
			if (order_creation_time != null && order_creation_time.trim().length() > 0) {
				sql = sql + "where order_creation_time like '" + order_creation_time + '%' + "'";
			}
			// System.out.println(sql);
			rs = st.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt("result");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return count;
	}

	/**
	 * 按照车次信息和用户姓名进行多表连接统计订单数量 参数：车次号，用户真实姓名，订单创建时间 返回：符合条件的订单数量
	 * 
	 * @return
	 */
	public int countOrderByCondition(String order_number, String user_cardnumber, String order_creation_time) {
		int count = 0;
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			connection = DBHelp.getConnect();
			st = connection.createStatement();
			String sql = "select count(*) as result from tbl_order ";
			if (order_number != null && order_number.trim().length() > 0) {
				sql = sql + "o,tbl_train t where o.train_id = t.train_id and order_number = '" + order_number + "'";
			}
			if (user_cardnumber != null && user_cardnumber.trim().length() > 0) {
				sql = sql + "o,tbl_user u where o.user_id = u.user_id and user_cardnumber = '" + user_cardnumber + "'";
			}
			if (order_creation_time != null && order_creation_time.trim().length() > 0) {
				sql = sql + "where order_creation_time like '" + order_creation_time + '%' + "'";
			}
			// System.out.println(sql);
			rs = st.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return count;

	}

	/**
	 * 
	 * select order_seat_type t,sum(order_tiket_price) s,count(order_id) o from
	 * tbl_order where order_seat_type='硬座' and
	 * (str_to_date(order_creation_time,'%Y-%m-%d')>=str_to_date('2019-01-01','%Y-%m-%d')
	 * and
	 * str_to_date(order_creation_time,'%Y-%m-%d')<=str_to_date('2019-07-01','%Y-%m-%d'))
	 * group by order_seat_type union select order_seat_type
	 * t,sum(order_tiket_price) s ,count(order_id) o from tbl_order where
	 * order_seat_type='硬卧' and
	 * (str_to_date(order_creation_time,'%Y-%m-%d')>=str_to_date('2019-01-01','%Y-%m-%d')
	 * and
	 * str_to_date(order_creation_time,'%Y-%m-%d')<=str_to_date('2019-07-01','%Y-%m-%d'))
	 * group by order_seat_type union select order_seat_type t
	 * ,sum(order_tiket_price) s ,count(order_id) o from tbl_order where
	 * order_seat_type='软卧' and
	 * (str_to_date(order_creation_time,'%Y-%m-%d')>=str_to_date('2019-01-01','%Y-%m-%d')
	 * and
	 * str_to_date(order_creation_time,'%Y-%m-%d')<=str_to_date('2019-07-01','%Y-%m-%d'))
	 * group by order_seat_type union select order_seat_type t
	 * ,sum(order_tiket_price) s ,count(order_id) o from tbl_order where
	 * order_seat_type='无座' and
	 * (str_to_date(order_creation_time,'%Y-%m-%d')>=str_to_date('2019-01-01','%Y-%m-%d')
	 * and
	 * str_to_date(order_creation_time,'%Y-%m-%d')<=str_to_date('2019-07-01','%Y-%m-%d'))
	 * group by order_seat_type
	 * 
	 */

	public List<List> total_order(String star_time, String end_time) {
		List<List> buffer = new ArrayList<List>();

		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			connection = DBHelp.getConnect();
			st = connection.createStatement();
			String sql = "select order_seat_type t ,sum(order_tiket_price) s ,count(order_id) o from tbl_order \r\n"
					+ "		where order_seat_type='硬座' and \r\n"
					+ "		(str_to_date(order_creation_time,'%Y-%m-%d')>=str_to_date('" + star_time
					+ "','%Y-%m-%d') and \r\n" + "		str_to_date(order_creation_time,'%Y-%m-%d')<=str_to_date('"
					+ end_time + "','%Y-%m-%d'))\r\n" + "		group by order_seat_type\r\n" + "		union\r\n"
					+ "		select order_seat_type t ,sum(order_tiket_price) s ,count(order_id) o from tbl_order \r\n"
					+ "		where order_seat_type='硬卧' and \r\n"
					+ "		(str_to_date(order_creation_time,'%Y-%m-%d')>=str_to_date('" + star_time
					+ "','%Y-%m-%d') and \r\n" + "		str_to_date(order_creation_time,'%Y-%m-%d')<=str_to_date('"
					+ end_time + "','%Y-%m-%d'))\r\n" + "		group by order_seat_type\r\n" + "		union\r\n"
					+ "		select order_seat_type t ,sum(order_tiket_price) s ,count(order_id) o from tbl_order \r\n"
					+ "		where order_seat_type='软卧' and \r\n"
					+ "		(str_to_date(order_creation_time,'%Y-%m-%d')>=str_to_date('" + star_time
					+ "','%Y-%m-%d') and \r\n" + "		str_to_date(order_creation_time,'%Y-%m-%d')<=str_to_date('"
					+ end_time + "','%Y-%m-%d'))\r\n" + "		group by order_seat_type\r\n" + "		union\r\n"
					+ "		select order_seat_type t ,sum(order_tiket_price) s ,count(order_id) o from tbl_order \r\n"
					+ "		where order_seat_type='无座' and \r\n"
					+ "		(str_to_date(order_creation_time,'%Y-%m-%d')>=str_to_date('" + star_time
					+ "','%Y-%m-%d') and \r\n" + "		str_to_date(order_creation_time,'%Y-%m-%d')<=str_to_date('"
					+ end_time + "','%Y-%m-%d'))\r\n" + "		group by order_seat_type";

			// System.out.println(sql);
			rs = st.executeQuery(sql);
			List data = null;

			while (rs.next()) {
				data = new ArrayList();
				data.add(rs.getString("t"));
				data.add(rs.getString("s"));
				data.add(rs.getString("o"));
				buffer.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return buffer;
	}
}
