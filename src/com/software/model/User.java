package com.software.model;

public class User {
	private int user_id;
	private String user_loginname;
	private String user_loginpwd;
	private String user_realname;
	private String user_cardnumber;
	private String user_telephone;
	private String user_gender;
	private String user_birthday;
	private String remark1;

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_loginname() {
		return user_loginname;
	}

	public void setUser_loginname(String user_loginname) {
		this.user_loginname = user_loginname;
	}

	public String getUser_loginpwd() {
		return user_loginpwd;
	}

	public void setUser_loginpwd(String user_loginpwd) {
		this.user_loginpwd = user_loginpwd;
	}

	public String getUser_realname() {
		return user_realname;
	}

	public void setUser_realname(String user_realname) {
		this.user_realname = user_realname;
	}

	public String getUser_cardnumber() {
		return user_cardnumber;
	}

	public void setUser_cardnumber(String user_cardnumber) {
		this.user_cardnumber = user_cardnumber;
	}

	public String getUser_telephone() {
		return user_telephone;
	}

	public void setUser_telephone(String user_telephone) {
		this.user_telephone = user_telephone;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_birthday() {
		return user_birthday;
	}

	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_loginname=" + user_loginname + ", user_loginpwd=" + user_loginpwd
				+ ", user_realname=" + user_realname + ", user_cardnumber=" + user_cardnumber + ", user_telephone="
				+ user_telephone + ", user_gender=" + user_gender + ", user_birthday=" + user_birthday + ", remark1="
				+ remark1 + "]";
	}

}
