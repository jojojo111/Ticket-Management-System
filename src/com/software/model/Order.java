package com.software.model;

public class Order {
	private int order_id;
	private String order_number;
	private String order_creation_time;
	private int user_id;
	private int train_id;
	private float order_tiket_price;
	private String order_pay_type;
	private String order_seat_type;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}

	public String getOrder_creation_time() {
		return order_creation_time;
	}

	public void setOrder_creation_time(String order_creation_time) {
		this.order_creation_time = order_creation_time;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getTrain_id() {
		return train_id;
	}

	public void setTrain_id(int train_id) {
		this.train_id = train_id;
	}

	public float getOrder_tiket_price() {
		return order_tiket_price;
	}

	public void setOrder_tiket_price(float order_tiket_price) {
		this.order_tiket_price = order_tiket_price;
	}

	public String getOrder_pay_type() {
		return order_pay_type;
	}

	public void setOrder_pay_type(String order_pay_type) {
		this.order_pay_type = order_pay_type;
	}

	public String getOrder_seat_type() {
		return order_seat_type;
	}

	public void setOrder_seat_type(String order_seat_type) {
		this.order_seat_type = order_seat_type;
	}

	@Override

	public String toString() {
		return "Order [order_id=" + order_id + ", order_number=" + order_number + ", order_creation_time="
				+ order_creation_time + ", user_id=" + user_id + ", train_id=" + train_id + ", order_tiket_price="
				+ order_tiket_price + ", order_pay_type=" + order_pay_type + ", order_seat_type=" + order_seat_type
				+ "]";
	}

}
