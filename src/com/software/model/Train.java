package com.software.model;

public class Train {
	private int train_id;
	private String train_number;
	private String train_start;
	private String train_end;
	private String train_start_time;
	private String train_end_time;
	private String train_runtime;
	private int soft_berth_number;
	private int hard_berth_number;
	private int hard_seat_number;
	private int stand_number;
	private double soft_berth_price;
	private double hard_berth_price;
	private double hard_seat_price;
	private double stand_price;
	private int admin_id;
	private String remark1;

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public int getTrain_id() {
		return train_id;
	}

	public void setTrain_id(int train_id) {
		this.train_id = train_id;
	}

	public String getTrain_number() {
		return train_number;
	}

	public void setTrain_number(String train_number) {
		this.train_number = train_number;
	}

	public String getTrain_start() {
		return train_start;
	}

	public void setTrain_start(String train_start) {
		this.train_start = train_start;
	}

	public String getTrain_end() {
		return train_end;
	}

	public void setTrain_end(String train_end) {
		this.train_end = train_end;
	}

	public String getTrain_start_time() {
		return train_start_time;
	}

	public void setTrain_start_time(String train_start_time) {
		this.train_start_time = train_start_time;
	}

	public String getTrain_end_time() {
		return train_end_time;
	}

	public void setTrain_end_time(String train_end_time) {
		this.train_end_time = train_end_time;
	}

	public String getTrain_runtime() {
		return train_runtime;
	}

	public void setTrain_runtime(String train_runtime) {
		this.train_runtime = train_runtime;
	}

	public int getSoft_berth_number() {
		return soft_berth_number;
	}

	public void setSoft_berth_number(int soft_berth_number) {
		this.soft_berth_number = soft_berth_number;
	}

	public int getHard_berth_number() {
		return hard_berth_number;
	}

	public void setHard_berth_number(int hard_berth_number) {
		this.hard_berth_number = hard_berth_number;
	}

	public int getHard_seat_number() {
		return hard_seat_number;
	}

	public void setHard_seat_number(int hard_seat_number) {
		this.hard_seat_number = hard_seat_number;
	}

	public int getStand_number() {
		return stand_number;
	}

	public void setStand_number(int stand_number) {
		this.stand_number = stand_number;
	}

	public double getSoft_berth_price() {
		return soft_berth_price;
	}

	public void setSoft_berth_price(double soft_berth_price) {
		this.soft_berth_price = soft_berth_price;
	}

	public double getHard_berth_price() {
		return hard_berth_price;
	}

	public void setHard_berth_price(double hard_berth_price) {
		this.hard_berth_price = hard_berth_price;
	}

	public double getHard_seat_price() {
		return hard_seat_price;
	}

	public void setHard_seat_price(double hard_seat_price) {
		this.hard_seat_price = hard_seat_price;
	}

	public double getStand_price() {
		return stand_price;
	}

	public void setStand_price(double stand_price) {
		this.stand_price = stand_price;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	@Override
	public String toString() {
		return "Train [train_id=" + train_id + ", train_number=" + train_number + ", train_start=" + train_start
				+ ", train_end=" + train_end + ", train_start_time=" + train_start_time + ", train_end_time="
				+ train_end_time + ", train_runtime=" + train_runtime + ", soft_berth_number=" + soft_berth_number
				+ ", hard_berth_number=" + hard_berth_number + ", hard_seat_number=" + hard_seat_number
				+ ", stand_number=" + stand_number + ", soft_berth_price=" + soft_berth_price + ", hard_berth_price="
				+ hard_berth_price + ", hard_seat_price=" + hard_seat_price + ", stand_price=" + stand_price
				+ ", admin_id=" + admin_id + "]";
	}

}
