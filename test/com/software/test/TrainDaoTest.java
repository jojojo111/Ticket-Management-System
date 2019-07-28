package com.software.test;

import java.util.List;

import org.junit.Test;

import com.software.dao.TrainDao;
import com.software.model.Train;

public class TrainDaoTest {

	/*
	 * �������
	 */
	@Test
	public void testMethodtianjiacheci() {
		Train train = new Train();
		train.setTrain_number("q111");
		train.setTrain_start("���");
		train.setTrain_end("����");
		train.setTrain_start_time("9:00");
		train.setTrain_end_time("10:00");
		train.setTrain_runtime("1��00");
		train.setSoft_berth_number(200);
		train.setHard_berth_number(200);
		train.setHard_seat_number(300);
		train.setStand_number(400);
		train.setSoft_berth_price(500);
		train.setHard_berth_price(300);
		train.setHard_seat_price(230);
		train.setStand_price(140);
		train.setAdmin_id(5);

		TrainDao trainDao = new TrainDao();
		boolean flag = trainDao.addTrain(train);
		if (flag) {
			System.out.println("success");
		} else {
			System.out.println("failure");
		}
	}

	/*
	 * ɾ�����β��� ���ߣ�ۭ��
	 */
	@Test
	public void testdelectTrain() {
		int train_id = 3;
		TrainDao traindao = new TrainDao();
		boolean flag = traindao.delectTrain(train_id);
		if (flag)
			System.out.println("success");
		else
			System.out.println("false");

	}

	/*
	 * �޸ĳ�����Ϣ���� ���ߣ�����
	 */
	@Test
	public void testupdateTrain() {
		Train train = new Train();
		TrainDao traindao = new TrainDao();
		train.setTrain_id(1);
		train.setTrain_number("G39");
		train.setTrain_start("����");
		train.setTrain_end("�Ͼ�");
		train.setTrain_start_time("19:04");
		train.setTrain_end_time("22:17");
		train.setTrain_runtime("3:13");
		train.setSoft_berth_number(100);
		train.setHard_berth_number(100);
		train.setHard_seat_number(100);
		train.setStand_number(150);
		train.setSoft_berth_price(80);
		train.setHard_berth_price(60);
		train.setHard_seat_price(40);
		train.setStand_price(20);
		train.setAdmin_id(1);
		boolean flag = traindao.updateTrain(train);
		if (flag)
			System.out.println("success");
		else
			System.out.println("false");

	}

	/*
	 * ���Գ��β�ѯ
	 */
	@Test
	public void testmethodchicchaxun() {
		TrainDao trainDao = new TrainDao();
		List<Train> users = trainDao.findTrain("G120", null, null, null, 1, 100);
		for (int i = 0; i < users.size(); i++) {
			Train train = users.get(i);
			System.out.println(train.toString());
		}
	}
}
