package com.software.model;

public class Admin {
	private int admin_id;
	private String admin_loginname;
	private int admin_loginpwd;

	public int getAdmin_id() {
		return admin_id;
	}

	public int getAdmin_loginpwd() {
		return admin_loginpwd;
	}

	public void setAdmin_loginpwd(int admin_loginpwd) {
		this.admin_loginpwd = admin_loginpwd;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_loginname() {
		return admin_loginname;
	}

	public void setAdmin_loginname(String admin_loginname) {
		this.admin_loginname = admin_loginname;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_loginname=" + admin_loginname + ", admin_loginpwd="
				+ admin_loginpwd + "]";
	}
}
