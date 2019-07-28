package com.software.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.software.model.Train;
import com.software.util.DBHelp;

/**
 * 
 * @author 董银磊、王恒、郗瑞
 *
 */
public class TrainDao {

	/**
	 * 增加车次 作者：董银磊
	 * 
	 */
	public boolean addTrain(Train train) {
		boolean flag = false;

		String sql = "insert into tbl_train(train_number,train_start,train_end,train_start_time, "
				+ "train_end_time,train_runtime,soft_berth_number,hard_berth_number, "
				+ "hard_seat_number,stand_number,soft_berth_price,hard_berth_price,hard_seat_price, "
				+ "stand_price,admin_id,remark1) " + "value('" + train.getTrain_number() + "','"
				+ train.getTrain_start() + "','" + train.getTrain_end() + "','" + train.getTrain_start_time() + "','"
				+ train.getTrain_end_time() + "','" + train.getTrain_runtime() + "','" + train.getSoft_berth_number()
				+ "'," + "'" + train.getHard_berth_price() + "','" + train.getHard_seat_number() + "','"
				+ train.getStand_number() + "','" + train.getSoft_berth_price() + "','" + train.getHard_berth_price()
				+ "','" + train.getHard_seat_price() + "','" + train.getStand_price() + "','" + train.getAdmin_id()
				+ "','0')";
		int count = DBHelp.executeSql(sql);
		if (count > 0) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 删除车次，根据主键id删除 作者：郗瑞
	 */
	public boolean delectTrain(int train_id) {
		boolean flag = false;
		// String sql = "delete from tbl_train where train_id=" + train_id;
		String sql = "update tbl_train set remark1='1' where train_id=" + train_id;
		int count = DBHelp.executeSql(sql);
		if (count > 0)
			flag = true;
		return flag;
	}

	public boolean recoverTrain(int train_id) {
		boolean flag = false;
		String sql = "update tbl_train set remark1='0' where train_id=" + train_id;
		int count = DBHelp.executeSql(sql);
		if (count > 0)
			flag = true;
		return flag;
	}

	/**
	 * 修改车次，根据id修改 作者：王恒
	 */
	public boolean updateTrain(Train train) {
		boolean flag = false;
		String sql = "update tbl_train\r\n" + "set train_number='" + train.getTrain_number() + "',train_start='"
				+ train.getTrain_start() + "',train_end='" + train.getTrain_end() + "',train_start_time='"
				+ train.getTrain_start_time() + "',\r\n" + "    train_end_time='" + train.getTrain_end_time()
				+ "',train_runtime='" + train.getTrain_runtime() + "',soft_berth_number=" + train.getSoft_berth_number()
				+ ",hard_berth_number=" + train.getHard_berth_number() + ",\r\n" + "    hard_seat_number="
				+ train.getHard_seat_number() + ",stand_number=" + train.getStand_number() + ",soft_berth_price="
				+ train.getSoft_berth_price() + ",hard_berth_price=" + train.getHard_berth_price() + ",hard_seat_price="
				+ train.getHard_seat_price() + ",stand_price=" + train.getStand_price() + ",\r\n" + "    admin_id="
				+ train.getAdmin_id() + "\r\n" + "where train_id = " + train.getTrain_id() + "";
		int count = DBHelp.executeSql(sql);
		if (count > 0)
			flag = true;
		return flag;
	}

	/**
	 * 修改
	 */

	public Train findTrainById(int trainId) {
		Train train = new Train();
		Connection connection = null;
		java.sql.Statement st = null;
		java.sql.ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();
			st = connection.createStatement();

			String sql = "select train_id,train_number,train_start,train_end,train_start_time,train_end_time,"
					+ "train_runtime,soft_berth_number,hard_berth_number,hard_seat_number,stand_number,"
					+ "soft_berth_price,hard_berth_price,hard_seat_price,stand_price,admin_id,remark1 from tbl_train where train_id ="
					+ trainId;

			rs = st.executeQuery(sql);

			if (rs.next()) {
				// 创建用户对象
				train = new Train();
				train.setTrain_id(rs.getInt("train_id"));
				train.setTrain_number(rs.getString("train_number"));
				train.setTrain_start(rs.getString("train_start"));
				train.setTrain_end(rs.getString("train_end"));
				train.setTrain_start_time(rs.getString("train_start_time"));
				train.setTrain_end_time(rs.getString("train_end_time"));
				train.setTrain_runtime(rs.getString("train_runtime"));
				train.setSoft_berth_number(rs.getInt("soft_berth_number"));
				train.setHard_berth_number(rs.getInt("hard_berth_number"));
				train.setHard_seat_number(rs.getInt("hard_seat_number"));
				train.setStand_number(rs.getInt("stand_number"));
				train.setSoft_berth_price(rs.getDouble("soft_berth_price"));
				train.setHard_berth_price(rs.getDouble("hard_berth_price"));
				train.setHard_seat_price(rs.getDouble("hard_seat_price"));
				train.setStand_price(rs.getDouble("stand_price"));
				train.setAdmin_id(rs.getInt("admin_id"));
				train.setRemark1(rs.getString("remark1"));
			}
			// 5.关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return train;
	}

	/**
	 * 查找车次 作者：董银磊
	 */
	public List<Train> findTrain(String train_number, String train_start, String train_end, String train_start_time,
			int currentPage, int pageSize) {
		List<Train> trains = new ArrayList<Train>();

		Connection connection = null;
		java.sql.Statement st = null;
		java.sql.ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();
			st = connection.createStatement();

			String sql = "select train_id,train_number,train_start,train_end,train_start_time,train_end_time,"
					+ "train_runtime,soft_berth_number,hard_berth_number,Hard_seat_number,stand_number,"
					+ "soft_berth_price,hard_berth_price,hard_seat_price,stand_price,admin_id,remark1 from tbl_train where 1=1 ";
			if (train_number != null && train_number.trim().length() > 0) {
				sql = sql + " and  train_number = '" + train_number + "'";
			}
			if (train_start != null && train_start.trim().length() > 0) {
				sql = sql + " and train_start = '" + train_start + "'";
			}
			if (train_end != null && train_end.trim().length() > 0) {
				sql = sql + " and train_end = '" + train_end + "'";
			}
			if (train_start_time != null && train_start_time.trim().length() > 0) {
				sql = sql + " and train_start_time = '" + train_start_time + "'";
			}

			sql = sql + " limit " + (currentPage - 1) * pageSize + "," + pageSize;
			rs = st.executeQuery(sql);
			Train train = null;
			while (rs.next()) {
				// 创建用户对象
				train = new Train();
				train.setTrain_id(rs.getInt("train_id"));
				train.setTrain_number(rs.getString("train_number"));
				train.setTrain_start(rs.getString("train_start"));
				train.setTrain_end(rs.getString("train_end"));
				train.setTrain_start_time(rs.getString("train_start_time"));
				train.setTrain_end_time(rs.getString("train_end_time"));
				train.setTrain_runtime(rs.getString("train_runtime"));
				train.setSoft_berth_number(rs.getInt("soft_berth_number"));
				train.setHard_berth_number(rs.getInt("hard_berth_number"));
				train.setHard_seat_number(rs.getInt("hard_seat_number"));
				train.setStand_number(rs.getInt("stand_number"));
				train.setSoft_berth_price(rs.getDouble("soft_berth_price"));
				train.setHard_berth_price(rs.getDouble("hard_berth_price"));
				train.setHard_seat_price(rs.getDouble("hard_seat_price"));
				train.setStand_price(rs.getDouble("stand_price"));
				train.setAdmin_id(rs.getInt("admin_id"));
				train.setRemark1(rs.getString("remark1"));
				trains.add(train);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}

		return trains;
	}

	public int getCountTrain(String train_number, String train_start, String train_end, String train_start_time) {
		int count = 0;

		Connection connection = null;
		java.sql.Statement st = null;
		java.sql.ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();
			st = connection.createStatement();

			String sql = "select count(*) from tbl_train where 1=1 ";
			if (train_number != null && train_number.trim().length() > 0) {
				sql = sql + " and  train_number = '" + train_number + "'";
			}
			if (train_start != null && train_start.trim().length() > 0) {
				sql = sql + " and train_start = '" + train_start + "'";
			}
			if (train_end != null && train_end.trim().length() > 0) {
				sql = sql + " and train_end = '" + train_end + "'";
			}
			if (train_start_time != null && train_start_time.trim().length() > 0) {
				sql = sql + " and train_start_time = '" + train_start_time + "'";
			}
			rs = st.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}

		return count;
	}

}
